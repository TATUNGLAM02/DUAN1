package com.example.duannhom10.Account;
import com.example.duannhom10.model.user;

<<<<<<< HEAD
=======

>>>>>>> 5fc002c472a9b4cb5f126ad5dfa85d4ab4d14417
public class LoginValidation {
    public boolean correct;

    public user curUser;
    public boolean isCorrect() {
        return correct;
    }
    public void setCorrect(boolean correct) {
        this.correct = correct;
    }
    public user getCurUser() {
        return curUser;
    }
    public void setCurUser(user curUser) {
        this.curUser = curUser;
    }
    public LoginValidation(user curUser,boolean correct) {
        this.curUser = curUser;
        this.correct = correct;
    }
    public LoginValidation(boolean correct) {
        this.correct = correct;
    }


}
