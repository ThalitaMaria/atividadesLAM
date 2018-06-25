import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class Utils {
    public FakeUser getInformacao(String end) {
        String json;
        FakeUser retorno;
        json = NetworkUtils.getJSONFromAPI(end);
        Log.i("Resultado", json);
        retorno = parseJson(json);

        return retorno;
    }

    private FakeUser parseJson(String json) {
        try {
            FakeUser pessoa = new FakeUser();

            JSONObject jsonObject = new JSONObject(json);
            JSONArray array = jsonObject.getJSONArray("results");

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date data;

            JSONObject objArray = array.getJSONObject(0);

            JSONObject obj = objArray.getJSONObject("user");
            //Atribui os objetos que estão nas camadas mais altas
            pessoa.setEmail(obj.getString("email"));
            pessoa.setUsername(obj.getString("username"));
            pessoa.setSenha(obj.getString("password"));
            pessoa.setTelefone(obj.getString("phone"));
            data = new Date(obj.getLong("dob") * 1000);
            pessoa.setNascimento(sdf.format(data));

            //Nome da pessoa é um objeto, instancia um novo JSONObject
            JSONObject nome = obj.getJSONObject("name");
            pessoa.setNome(nome.getString("first"));
            pessoa.setSobrenome(nome.getString("last"));

            //Endereço também é um objeto
            JSONObject endereco = obj.getJSONObject("location");
            pessoa.setEndereco(endereco.getString("street"));
            pessoa.setEstado(endereco.getString("state"));
            pessoa.setCidade(endereco.getString("city"));

            //Imagem é um objeto
            JSONObject foto = obj.getJSONObject("picture");
            pessoa.setFoto(baixarImagem(foto.getString("large")));

            return pessoa;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Bitmap baixarImagem(String url){
        try{
            URL endereco;
            InputStream inputStream;
            Bitmap imagem;
            endereco = new URL(url);
            inputStream = endereco.openStream();
            imagem = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return imagem;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }

}