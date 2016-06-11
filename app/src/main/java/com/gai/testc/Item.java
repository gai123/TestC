package com.gai.testc;

/**
 * Created with Android Studio.
 * User: gai
 * Date: 16/6/11
 * Time: 下午1:58
 */

public class Item {
    private int width;
    private int height;
    private String tag;
    private String leftof;
    private String rightof;
    private String topof;
    private String bottomof;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLeftof() {
        return leftof;
    }

    public void setLeftof(String leftof) {
        this.leftof = leftof;
    }

    public String getRightof() {
        return rightof;
    }

    public void setRightof(String rightof) {
        this.rightof = rightof;
    }

    public String getTopof() {
        return topof;
    }

    public void setTopof(String topof) {
        this.topof = topof;
    }

    public String getBottomof() {
        return bottomof;
    }

    public void setBottomof(String bottomof) {
        this.bottomof = bottomof;
    }

    public Item(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Item{" +
                "width=" + width +
                ", height=" + height +
                ", tag='" + tag + '\'' +
                ", leftof='" + leftof + '\'' +
                ", rightof='" + rightof + '\'' +
                ", topof='" + topof + '\'' +
                ", bottomof='" + bottomof + '\'' +
                '}';
    }
}
