package com.application.finalapplication;

//import com.application.sqliteexample.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SQLiteExampleActivity extends Activity {
    /** Called when the activity is first created. */
    private DBDefinitionManipulation dbOperation ;

    private EditText nameText;
    private EditText sexText;
    private EditText totalcreditsText;
    private EditText idEntry;

    private TextView labelView;
    private TextView displayView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main1);

        nameText = (EditText)findViewById(R.id.name);
        sexText = (EditText)findViewById(R.id.sex);
        totalcreditsText = (EditText)findViewById(R.id.totalcredits);
        idEntry = (EditText)findViewById(R.id.id_entry);

        labelView = (TextView)findViewById(R.id.label);
        displayView = (TextView)findViewById(R.id.display);



        Button addButton = (Button)findViewById(R.id.add);
        Button queryAllButton = (Button)findViewById(R.id.query_all);
        Button clearButton = (Button)findViewById(R.id.clear);
        // Button deleteAllButton = (Button)findViewById(R.id.delete_all);

        Button queryButton = (Button)findViewById(R.id.query);
        Button deleteButton = (Button)findViewById(R.id.delete);
        Button updateButton = (Button)findViewById(R.id.update);


        addButton.setOnClickListener(addButtonListener);
        queryAllButton.setOnClickListener(queryAllButtonListener);
        clearButton.setOnClickListener(clearButtonListener);
        //deleteAllButton.setOnClickListener(deleteAllButtonListener);

        queryButton.setOnClickListener(queryButtonListener);
        deleteButton.setOnClickListener(deleteButtonListener);
        updateButton.setOnClickListener(updateButtonListener);

        dbOperation = new DBDefinitionManipulation(this);
        dbOperation.open();
    }

    OnClickListener addButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Student student = new Student();
            student.Name = nameText.getText().toString();
            student.Sex = sexText.getText().toString();
            student.Totalcredits = Integer.parseInt(totalcreditsText.getText().toString());
            long colunm = dbOperation.insert(student);
            if (colunm == -1 ){
                labelView.setText("添加过程错误！");
            } else {
                labelView.setText("成功添加数据，ID："+String.valueOf(colunm));

            }
        }
    };

    OnClickListener queryAllButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Student[] students = dbOperation.queryAllData();
            if (students == null){
                labelView.setText("数据库中没有数据");
                return;
            }
            labelView.setText("数据库：");
            String msg = "";
            for (int i = 0 ; i<students.length; i++){
                msg += students[i].toString()+"\n";
            }
            displayView.setText(msg);
        }
    };

    OnClickListener clearButtonListener = new OnClickListener() {

        @Override
        public void onClick(View v) {
            displayView.setText("");
        }
    };

    OnClickListener queryButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            int id = Integer.parseInt(idEntry.getText().toString());
            Student[] students = dbOperation.queryOneData(id);

            if (students == null){
                labelView.setText("数据库中没有ID为"+String.valueOf(id)+"的数据");
                return;
            }
            labelView.setText("数据库：");
            displayView.setText(students[0].toString());
        }
    };

    OnClickListener deleteButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            long id = Integer.parseInt(idEntry.getText().toString());
            long result = dbOperation.deleteOneData(id);
            String msg = "删除ID为"+idEntry.getText().toString()+"的数据" + (result>0?"成功":"失败");
            labelView.setText(msg);
        }
    };

    OnClickListener updateButtonListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            Student student = new Student();
            student.Name = nameText.getText().toString();
            student.Sex = sexText.getText().toString();
            student.Totalcredits = Integer.parseInt(totalcreditsText.getText().toString());
            long id = Integer.parseInt(idEntry.getText().toString());
            long count = dbOperation.updateOneData(id, student);
            if (count == -1 ){
                labelView.setText("更新错误！");
            } else {
                labelView.setText("更新成功，更新数据"+String.valueOf(count)+"条");

            }
        }
    };

}