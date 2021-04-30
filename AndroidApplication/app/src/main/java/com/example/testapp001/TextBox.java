package com.example.testapp001;

public class TextBox implements QuizBox, AnswerBox, CorrectBox{
    //String QuizText;
    String QuizText = "コードネームを選んでください。";
    String[] Answers;
    String CorrectText;
    int ary;
    TextBox(int count){
        ary = count;

        //this.setQuiz();
        this.setAnswers();
        this.setCorrect();
    }
    public void setQuiz(){
        //QuizText = QuizTxtAry[ary];
    }
    public String getQuiz(){
        return QuizText;
    }
    public void setAnswers(){
        Answers = AnswersAry[ary];
    }
    public String[] getAnswers(){
        return Answers;
    }
    public void setCorrect(){
        CorrectText = CorrectTxtAry[ary];
    }
    public String getCorrect(){
        return CorrectText;
    }
}

interface QuizBox{
    /*String[] QuizTxtAry = {
            "コードネームを選んでください。", "調号を以下の内から選んでください。", "コードネームを以下から選んでください。", "楽器名を以下から選んでください。"};*/
    void setQuiz();
}
interface AnswerBox{
    String[][] AnswersAry ={ {"C7", "C-7", "CM7", "C-7(-5)"}, {"Cadd9", "C-9", "C9", "CM9"},
            {"C-7(-5)", "Cadd9", "C-7(-9)", "C9"}, {"Cadd(-9)", "Cadd9", "Cdim9", "C- add9"},
            {"Cadd9", "Csus4 7", "Cadd(#9)", "C9"}, {"Csus2","Csus4", "Caug", "Cdim"},
            {"Cdim(-9)", "Caug M7", "C-M7", "Caug7"}, {"C-M7", "C9", "CaugM7", "Csus4 7"},
            {"Caug", "CmM7", "Cdim", "Csus4"}, {"Cdim7", "C-7(-5)", "Caug7", "C-7"},
            {"Cdim7", "CM7", "C-7(-5)", "Cadd(11)"}, {"C-7", "C7", "CM7", "C-9"},
            {"C9", "Cm9", "CM7(-9)", "Caug(9)"},{"C9", "C-9", "C-M7", "CM7(#9)"},
            {"C7", "CM7", "C-M7", "C-7"}, {"Csus4", "Cdim", "Caug", "Csus2"}};
    void setAnswers();
}
interface CorrectBox{
    String[] CorrectTxtAry =
            {"C7", "CM9", "Cadd9", "Cadd(-9)", "Cadd(#9)", "Caug", "Caug7", "CaugM7", "Cdim", "Cdim7", "C-7(-5)", "CM7", "CM7(-9)", "CM7(#9)", "C-7", "Csus4"};
    void setCorrect();
}