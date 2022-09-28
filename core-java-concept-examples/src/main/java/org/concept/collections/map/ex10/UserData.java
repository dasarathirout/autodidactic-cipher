package org.concept.collections.map.ex10;

public class UserData {
    private int value;
    private String content;
    private boolean isActive;

    UserData() {
        super();
        value = 0;
        content = "NULL";
        isActive = false;
    }

    UserData(int value, String content, boolean isActive) {
        this();
        this.value = value;
        this.content = content;
        this.isActive = isActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserData data = (UserData) o;
        //return content.equals(data.content);
        return true;
    }

    @Override
    public int hashCode() {
        return this.value;
        //return super.hashCode();
    }
    @Override
    public String toString(){
        return value+"-"+content+"-"+isActive;
    }
}
