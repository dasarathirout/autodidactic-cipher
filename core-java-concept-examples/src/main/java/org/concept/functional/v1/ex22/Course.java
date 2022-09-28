package org.concept.functional.v1.ex22;

public class Course {
    private String name;
    private String category;
    private int review;
    private int userCount;
    public Course(String name, String category, int review, int userCount) {
        this.name = name;
        this.category = category;
        this.review = review;
        this.userCount = userCount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReview() {
        return review;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public int getUserCount() {
        return userCount;
    }

    public void setUserCount(int userCount) {
        this.userCount = userCount;
    }

    @Override
    public String toString() {
        return name + "-" + category + "-" + review + "-" + userCount;
    }

    private String value(){
        return "Course { name=" + name + " | category=" + category + " | review=" + review + " | userCount=" + userCount + " }";
    }
}