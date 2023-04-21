package com.example.fastfashion_app;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.example.fastfashion_app.R;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ViewUsers extends AppCompatActivity {
    ListView UserListView;
    String Key;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        UserListView = findViewById(R.id.UserListView);

        getUsers();
    }

    private void getUsers() {
        Key = "apiFastFashion";
        Call<List<Results>> call = RetrofitClient.getInstance().getMyApi().getUsers(Key);
        call.enqueue(new Callback<List<Results>>() {
            @Override
            public void onResponse(Call<List<Results>> call, Response<List<Results>> response) {
                List<Results> myUserList = response.body();
                String[] oneUsers = new String[myUserList.size()];
                for (int i = 0; i < myUserList.size(); i++) {
                    oneUsers[i] = myUserList.get(i).getName();
                }
                UserListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneUsers) );
            }

            @Override
            public void onFailure(Call<List<Results>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro", Toast.LENGTH_LONG).show();
            }
        });
    }
}