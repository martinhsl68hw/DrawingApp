package shapes;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

public class ShapeDB {
    //private String urlHead="http://localhost:8080";
    //private String urlHead="http://localhost:8080/GradleREST";
    private String urlHead="https://gradlerest.herokuapp.com";
    private ShapeReadWrite<Circle> srwC = new ShapeReadWrite<Circle>(urlHead);
    private ShapeReadWrite<Rect> srwR = new ShapeReadWrite<Rect>(urlHead);
    private ShapeReadWrite<Square> srwS = new ShapeReadWrite<Square>(urlHead);

    private ArrayList<Shape> shapes;
    public ShapeDB(){
        shapes=new ArrayList<Shape>();
        getRemoteShapes(shapes);
    }

    private void getRemoteShapes(ArrayList<Shape> shapes) {
        List<Circle> lsc=srwC.getRemoteShapeList(new TypeToken<List<Circle>>(){},"/getCircles");
        for(Circle c:lsc)shapes.add(c);
        List<Rect> lsr=srwR.getRemoteShapeList(new TypeToken<List<Rect>>(){},"/getRects");
        for(Rect r:lsr)shapes.add(r);
        List<Square> lss=srwS.getRemoteShapeList(new TypeToken<List<Square>>(){},"/getSquares");
        for(Square s:lss)shapes.add(s);
    }

    public void addCircle(Point pos, Color col, int radius){
        Circle c=new Circle(pos,col,radius);
        shapes.add(c);
        srwC.addRemoteShape(c,"/addCircle");
    }
    public void addRect(Point pos, Color col, int w, int h){
        Rect c=new Rect(pos,col,w,h);
        shapes.add(c);
        srwR.addRemoteShape(c,"/addRect");
    }
    public void addSquare(Point pos, Color col, int side){
        Square sq =new Square(pos,col,side);
        shapes.add(sq);
        srwS.addRemoteShape(sq,"/addSquare");
    }
    public void drawShapes(Graphics g){
        for(Shape p:shapes)
            p.draw(g);
    }

    private int getCount(Class a){
        int count=0;
        for(Shape p:shapes){
            if (p.getClass() == a) count++;
        }
        return count;
    }
    int getNumCircles() {
        return getCount(Circle.class);
    }
    int getNumRects() {
        return getCount(Rect.class);
    }
    int getNumSquares() {
        return getCount(Square.class);
    }

}

class ShapeReadWrite<T>{
    private final String url;

    public ShapeReadWrite(String url) {
        this.url=url;
    }

    public List<T> getRemoteShapeList(TypeToken type,String urlPath) {
        List<T> shapeList=null;
        try {
            URL myURL = new URL(url+urlPath);



            Gson gson = new Gson();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(myURL.openStream()));

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                String jsonString = inputLine;

                shapeList = gson.fromJson(jsonString, type.getType());

                System.out.println(inputLine);
            }
            in.close();
        } catch (Exception e) {

        }
        return shapeList;
    }

    public void addRemoteShape(Shape s,String urlPath) {
        try {
            Gson gson = new Gson();
            String jsonString = gson.toJson(s);

            String urlParameters = jsonString;
            byte[] postData = urlParameters.getBytes(StandardCharsets.UTF_8);
            int postDataLength = postData.length;
            String request = url + urlPath;
            URL url = new URL(request);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setRequestProperty("charset", "utf-8");
            conn.setRequestProperty("Content-Length", Integer.toString(postDataLength));
            conn.setUseCaches(false);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(postData, 0, postData.length);
            }

            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream(), "utf-8"))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response.toString());
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.err.format("Exception occurred trying to read '%s'.", "CircleData.txt");
            e.printStackTrace();
        }
    }


}