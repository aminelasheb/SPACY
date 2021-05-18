package com.example.spacy;


public class answerClass {
    private final int qc;
    private final int optionA;
    private final int optionB;
    private final int optionC;
    private final int optionD;
    private final int questionid;
    private final int answerid;

    public answerClass(int qC, int questionide, int optiona, int optionb, int optionc, int optiond, int answeride) {
        questionid = questionide;
        optionA = optiona;
        optionB = optionb;
        optionC = optionc;
        optionD = optiond;
        answerid = answeride;
        qc = qC;

    }

    public int getQc() {
        return qc;
    }

    public int getOptionA() {
        return optionA;
    }

    public int getOptionB() {
        return optionB;
    }

    public int getOptionC() {
        return optionC;
    }

    public int getOptionD() {
        return optionD;
    }

    public int getQuestionid() {
        return questionid;
    }

    public int getAnswerid() {
        return answerid;
    }


}

