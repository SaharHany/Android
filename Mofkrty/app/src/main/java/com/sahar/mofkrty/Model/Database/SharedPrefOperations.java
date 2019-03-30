package com.sahar.mofkrty.Model.Database;

public interface SharedPrefOperations {
    public boolean checkUser(String username,String password);
    public boolean regUser(String username,String password);

    public void setLoggedInUser(String username);

    public String getLoggedInValue();
}
