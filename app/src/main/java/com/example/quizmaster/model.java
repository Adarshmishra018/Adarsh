package com.example.quizmaster;

public class model {
    String Question;
    String oA;
    String oB;
    String oC;
    String oD;
    String ans;

    public model(String Question,String oA,String oB,String oC,String oD,String ans) {
        this.Question =Question;
        this.oA =oA;
        this.oB =oB;
        this.oC =oC;
        this.oD =oD;
        this.ans =ans;
    }

    public String getoD() {
        return oD;
    }

    public void setoD(String oD) {
        this.oD = oD;
    }

    public String getoC() {
        return oC;
    }

    public void setoC(String oC) {
        this.oC = oC;
    }

    public String getoB() {
        return oB;
    }

    public void setoB(String oB) {
        this.oB = oB;
    }

    public String getoA() {
        return oA;
    }

    public void setoA(String oA) {
        this.oA = oA;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getQuestion() {
        return Question;
    }

    public void setQuestion(String question) {
        Question = question;
    }
}
