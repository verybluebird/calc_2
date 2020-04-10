package com.company;


class PushCreator implements Creator {
    @Override
    public Command create() {
        return new Push();
    }

}

class PopCreator implements Creator {


    @Override
    public Command create() {
        return new Pop();
    }
}

class SumCreator implements Creator {


    @Override
    public Command create() {
        return new Sum();
    }
}

class SubtractionCreator implements Creator {


    @Override
    public Command create() {
        return new Subtraction();
    }
}

class MultiplicationCreator implements Creator {


    @Override
    public Command create() {
        return new Multiplication();
    }
}

class CommentCreator implements Creator {

    @Override
    public Command create() {
        return new Comment();
    }
}

class DivideCreator implements Creator {

    @Override
    public Command create() {
        return new Divide();
    }
}

class PrintCreator implements Creator {


    @Override
    public Command create() {
        return new Print();
    }
}

class SqrtCreator implements Creator {


    @Override
    public Command create() {
        return new Sqrt();
    }
}

class DefineCreator implements Creator {

    @Override
    public Command create() {
        return new Define();
    }
}

public class Main {
    Creator creator = new SqrtCreator();
    Command command= creator.create();
    static Creator createCommandCreator (String commands){
        return map(commands);
    }
}

//    com.company.Command initialize() throws Exception {
//        config = readConfigFile();
//        if (config.command == "+") {
//            creator = new SqrtCreator();
//        } else if (config.command == "-") {
//            creator = new SubtractionCreator();
//        } else if (config.command == "/") {
//            creator = new DivideCreator();
//        } else if (config.command == "*") {
//            creator = new MultiplicationCreator();
//        } else if (config.command == "DEFINE") {
//            creator = new DefineCreator();
//        } else if (config.command == "SQRT") {
//            creator = new SqrtCreator();
//        } else if (config.command == "#") {
//            creator = new CommentCreator();
//        } else if (config.comment == "PRINT") {
//            creator = new PrintCreator();
//        } else if (config.comment == "POP") {
//            creator = new PopCreator();
//        } else if (config.comment == "PUSH") {
//            creator = new PushCreator();
//        } else {
//            throw new Exception("Error! Unknown command!");
//        }
//
//
//        public static void main (String[]args){
//            // write your code here
//        }
//    }