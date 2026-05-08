package com.example.simpleanimation_studentalik;
import android.app.Activity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends Activity {
    // константы для ID пунктов меню
    final int MENU_ALPHA_ID = 1;
    final int MENU_SCALE_ID = 2;
    final int MENU_TRANSLATE_ID = 3;
    final int MENU_ROTATE_ID = 4;
    final int MENU_COMBO_ID = 5;

    TextView tv;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tv = (TextView) findViewById(R.id.tv);
        // регистрируем контекстное меню для компонента tv
        registerForContextMenu(tv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenuInfo menuInfo) {
        // TODO Auto-generated method stub
        if (v.getId() == R.id.tv) {
            // добавляем пункты
            menu.add(0, MENU_ALPHA_ID, 0, "alpha");
            menu.add(0, MENU_SCALE_ID, 0, "scale");
            menu.add(0, MENU_TRANSLATE_ID, 0, "translate");
            menu.add(0, MENU_ROTATE_ID, 0, "rotate");
            menu.add(0, MENU_COMBO_ID, 0, "combo");
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        Animation anim = null;
        // определяем какой пункт был нажат
        int itemId = item.getItemId();

        if (itemId == MENU_ALPHA_ID) {
            anim = AnimationUtils.loadAnimation(this, R.anim.myalpha);
        } else if (itemId == MENU_SCALE_ID) {
            anim = AnimationUtils.loadAnimation(this, R.anim.myscale);
        } else if (itemId == MENU_TRANSLATE_ID) {
            anim = AnimationUtils.loadAnimation(this, R.anim.mytrans);
        } else if (itemId == MENU_ROTATE_ID) {
            anim = AnimationUtils.loadAnimation(this, R.anim.myrotate);
        } else if (itemId == MENU_COMBO_ID) {
            anim = AnimationUtils.loadAnimation(this, R.anim.mycombo);
        }
        // запускаем анимацию для компонента tv
        tv.startAnimation(anim);
        return super.onContextItemSelected(item);
    }


}