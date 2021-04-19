import composite.Rectangle;
import composite.controls.ButtonControl;
import composite.controls.CheckBox;
import composite.controls.CompositeControl;
import composite.controls.TextControl;

public class MainAppComposite {
    public static void main(String[] args) {
        test();
    }

    private static void test(){
        CompositeControl mainForm = new CompositeControl(new Rectangle(100,100,0,0));
        mainForm.addControl(new ButtonControl(new Rectangle(0,0, 100, 30), "Привет, я - кнопка"));
        mainForm.addControl(new ButtonControl(new Rectangle(0, 50, 100, 30), "Я втрая кнопка"));
        mainForm.addControl(new CheckBox(new Rectangle(0, 100, 100, 30), "Я чекбокс", true));

        CompositeControl subForm = new CompositeControl(new Rectangle(0, 0,0,0));
        subForm.addControl(new TextControl(new Rectangle(0, 0, 200, 40), "Введите логин"));
        subForm.addControl(new TextControl(new Rectangle(0, 100, 200, 40), "Введите пароль", true));

        mainForm.addControl(subForm);

        mainForm.draw();
    }
}
