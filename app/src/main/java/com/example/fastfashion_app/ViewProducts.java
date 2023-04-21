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

public class ViewProducts extends AppCompatActivity {
    ListView ProductListView;
    String Key;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);

        ProductListView = findViewById(R.id.ProductListView);

        getProducts();
    }

    private void getProducts() {
        Key = "apiFastFashion";
        Call<List<ResultsProducts>> call = RetrofitClient.getInstance().getMyApi().getProducts(Key);
        call.enqueue(new Callback<List<ResultsProducts>>() {
            @Override
            public void onResponse(Call<List<ResultsProducts>> call, Response<List<ResultsProducts>> response) {
                List<ResultsProducts> myProductList = response.body();
                String[] oneUsers = new String[myProductList.size()];
                for (int i = 0; i < myProductList.size(); i++) {
                    oneUsers[i] = myProductList.get(i).getName();
                }
                ProductListView.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, oneUsers) );
            }

            @Override
            public void onFailure(Call<List<ResultsProducts>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Ocorreu um erro", Toast.LENGTH_LONG).show();
            }
        });
    }
}