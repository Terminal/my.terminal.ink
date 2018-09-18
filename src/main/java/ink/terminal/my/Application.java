package ink.terminal.my;

import ink.terminal.my.data.DBHelper;

import static spark.Spark.*;

public  class Application {
    public static void main(String[] args) {
        port(8080);

        DBHelper db = new DBHelper();
    }
}
