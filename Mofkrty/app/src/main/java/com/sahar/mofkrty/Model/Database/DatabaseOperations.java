package com.sahar.mofkrty.Model.Database;

public interface DatabaseOperations {
    public boolean saveToFile(String username , String title , String body);
    public String loadFromFile(String username , String title);

}
