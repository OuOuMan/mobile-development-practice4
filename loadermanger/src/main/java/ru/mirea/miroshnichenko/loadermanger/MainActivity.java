package ru.mirea.miroshnichenko.loadermanger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements
        LoaderManager.LoaderCallbacks<String>  {

    public final String TAG = this.getClass().getSimpleName();
    private int LoaderID = 1234;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) {
        Log.d(TAG, "onLoaderReset");
    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int i, @Nullable Bundle bundle) {
        if (i == LoaderID) {
            return new MyLoader(this, bundle);
        }
        return null;
    }
    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String s) {
        if (loader.getId() == LoaderID) {
            LoaderID++;
            TextView textView = (TextView) findViewById(R.id.resultText);
            textView.setText(s);
        }
    }

    public void clickHandler(View view) {
        Bundle bundle = new Bundle();
        TextView editText = (EditText) findViewById(R.id.userText);
        String text = editText.getText().toString();
        bundle.putString("text", text);
        getSupportLoaderManager().initLoader(LoaderID, bundle, this);
    }
}