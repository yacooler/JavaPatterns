package composite;

import composite.controls.TextControl;

public class MainAppMemento {
    public static void main(String[] args) {
        test();
    }

    private static void test() {
        //Сериализуем объект
        BaseControlObject textControl = new TextControl(new Rectangle(0, 100, 200, 40), "Введите пароль", true);
        textControl.draw();
        System.out.println(textControl.serializeObject());

        System.out.println();

        //Десериализуем объект
        BaseControlObject textControl2 = new TextControl();
        textControl2.deserializeObject("text:\"Введите пароль\",enabled:false,bounds.x:0,bounds.y:100,bounds.width:200,bounds.height:40,password:true");
        textControl2.draw();

    }
}
