package ink.terminal.my;

import ink.terminal.my.data.DBHelper;

import static spark.Spark.*;

public  class Application {
    public static void main(String[] args) {
        port(Integer.getInteger("app.port", 8080));
        threadPool(Integer.getInteger("app.pool.max", -1), Integer.getInteger("app.pool.min", -1),
                Integer.getInteger("app.pool.idle_timeout", -1));
        String staticFileLocation = System.getProperty("app.static_file_location");
        if(staticFileLocation != null) {
            staticFileLocation(staticFileLocation);
        }
        String externalStaticFileLocation = System.getProperty("app.external_static_file_location");
        if(externalStaticFileLocation != null) {
            externalStaticFileLocation(externalStaticFileLocation);
        }

        DBHelper db = new DBHelper();
    }
}
