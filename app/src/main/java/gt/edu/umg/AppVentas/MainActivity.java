package gt.edu.umg.AppVentas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import gt.edu.umg.AppVentas.models.DetalleFactura;
import gt.edu.umg.AppVentas.models.Factura;
import gt.edu.umg.AppVentas.network.ApiService;
import gt.edu.umg.AppVentas.network.RetrofitClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText etCliente, etNit, etProducto, etDescripcion, etCantidad, etPrecio;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar los componentes del activity_main.xml con los elementos de la vista
        etCliente = findViewById(R.id.etCliente);
        etNit = findViewById(R.id.etNit);
        etProducto = findViewById(R.id.etProducto);
        etDescripcion = findViewById(R.id.etDescripcion);
        etCantidad = findViewById(R.id.etCantidad);
        etPrecio = findViewById(R.id.etPrecio);
        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(v -> enviarVenta());
    }

    private void enviarVenta() {
        // 1. Obtener los datos de la pantalla
        String cliente = etCliente.getText().toString();
        String nit = etNit.getText().toString();
        String producto = etProducto.getText().toString();
        String descripcion = etDescripcion.getText().toString();

        // Validar que no estén vacíos
        if (cliente.isEmpty() || producto.isEmpty() || etCantidad.getText().toString().isEmpty() || etPrecio.getText().toString().isEmpty()) {
            Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        int cantidad = Integer.parseInt(etCantidad.getText().toString());
        double precio = Double.parseDouble(etPrecio.getText().toString());
        double total = cantidad * precio;

        // 2. Obtener fecha actual
        String fechaActual = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(new Date());

        // 3. Crear el detalle de la factura
        DetalleFactura detalle = new DetalleFactura(producto, cantidad, precio, descripcion, total, 1);
        List<DetalleFactura> listaDetalles = new ArrayList<>();
        listaDetalles.add(detalle);

        // 4. Crear la Factura (Cabecera)
        // Generamos un número de factura aleatorio o basado en el tiempo para que no choque
        String numFactura = String.valueOf(System.currentTimeMillis() / 1000);

        Factura nuevaFactura = new Factura(numFactura, fechaActual, cliente, nit, total, "App Movil", listaDetalles);

        // 5. Hacer la petición HTTP con Retrofit
        ApiService apiService = RetrofitClient.getClient().create(ApiService.class);
        Call<Factura> call = apiService.registrarFactura(nuevaFactura);

        call.enqueue(new Callback<Factura>() {
            @Override
            public void onResponse(Call<Factura> call, Response<Factura> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "¡Venta guardada con éxito!", Toast.LENGTH_LONG).show();
                    // Limpiar los campos
                    etCliente.setText(""); etNit.setText(""); etProducto.setText(""); etDescripcion.setText(""); etCantidad.setText(""); etPrecio.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Error del servidor: " + response.code(), Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<Factura> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error de red: " + t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}