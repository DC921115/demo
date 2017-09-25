package com.example.ding.application2.bean;

public class WordInfo {
    private String wordName;
    private String wordNotice;
    private String grade;
    private String imageA;
    private String imageB;
    private String imageC;
    private String imageD;
    private String answer;

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String getWordNotice() {
        return wordNotice;
    }

    public void setWordNotice(String wordNotice) {
        this.wordNotice = wordNotice;
    }

    public String getImageA() {
        return imageA;
    }

    public void setImageA(String imageA) {
        this.imageA = imageA;
    }

    public String getImageB() {
        return imageB;
    }

    public void setImageB(String imageB) {
        this.imageB = imageB;
    }

    public String getImageC() {
        return imageC;
    }

    public void setImageC(String imageC) {
        this.imageC = imageC;
    }

    public String getImageD() {
        return imageD;
    }

    public void setImageD(String imageD) {
        this.imageD = imageD;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String[] getValues() {
        return new String[]{
                this.wordName,
                this.wordNotice,
                this.grade,
                this.imageA,
                this.imageB,
                this.imageC,
                this.imageD,
                this.answer
        };
    }

    public void setValues(String[] values) {
        if (values == null || values.length != 8) {
            return;
        }
        this.wordName = values[0];
        this.wordNotice = values[1];
        this.grade = values[2];
        this.imageA = values[3];
        this.imageB = values[4];
        this.imageC = values[5];
        this.imageD = values[6];
        this.answer = values[7];
    }
}
