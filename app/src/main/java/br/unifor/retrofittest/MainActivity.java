package br.unifor.retrofittest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.gson.Gson;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getContacts();
        getContactById("10");
        createContact(new Contact("Antonio", "88 99777030", "rafpviana@gmail.com", "Deu Certo"));
        updateContact("49", new Contact("Gabriel", "88 99777030", "rafpviana@gmail.com", "Deu Certo"));
        deleteContact("51");
    }

    public void getContacts(){

        ContactService contactService = ContactService.retrofit.create(ContactService.class);

        Call<ArrayList<Contact>> callContacts = contactService.getContacts();

        callContacts.enqueue(new Callback<ArrayList<Contact>>() {
            @Override
            public void onResponse(Call<ArrayList<Contact>> call, Response<ArrayList<Contact>> response) {
                String jsonContacts = new Gson().toJson(response.body());
                Log.i("onResponse Retrofit", " ");
                Log.i("Contacts List", jsonContacts);

            }

            @Override
            public void onFailure(Call<ArrayList<Contact>> call, Throwable t) {
                Log.i("onFailure Retrofit", t.getMessage());
                Log.i("Contacts List", " ");
            }
        });
    }

    public void getContactById(String id){

        ContactService contactService = ContactService.retrofit.create(ContactService.class);

        Call<Contact> callContact = contactService.getContactById(id);

        callContact.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                String jsonContact = new Gson().toJson(response.body());
                Log.i("onResponse Retrofit", " ");
                Log.i("Contact", jsonContact);
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                Log.i("onFailure Retrofit", t.getMessage());
                Log.i("Contact", " ");
            }
        });
    }

    public void createContact(Contact contact) {
        ContactService contactService = ContactService.retrofit.create(ContactService.class);

        Call<Contact> callContact = contactService.createContact(contact);

        callContact.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                String jsonContactCreated = new Gson().toJson(response.body());
                Log.i("onResponse Retrofit", " ");
                Log.i("Contact Created", jsonContactCreated);
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                Log.i("onFailure Retrofit", t.getMessage());
                Log.i("Contact Created", " ");
            }
        });
    }

    public void updateContact(String id, Contact contact){
        ContactService contactService = ContactService.retrofit.create(ContactService.class);

        Call<Contact> callContact = contactService.updateContact(id, contact);

        callContact.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                String jsonContactUpdated = new Gson().toJson(response.body());

                Log.i("onResponse Retrofit", " ");
                Log.i("Contact Updated", jsonContactUpdated);
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                Log.i("onFailure Retrofit", t.getMessage());
                Log.i("Contact Updated", " ");
            }
        });
    }

    public void deleteContact(String id){
        ContactService contactService = ContactService.retrofit.create(ContactService.class);

        Call<Contact> callContact = contactService.deleteContact(id);

        callContact.enqueue(new Callback<Contact>() {
            @Override
            public void onResponse(Call<Contact> call, Response<Contact> response) {
                String jsonContactUpdated = new Gson().toJson(response.body());

                Log.i("onResponse Retrofit", " ");
                Log.i("Contact Deleted", jsonContactUpdated);
            }

            @Override
            public void onFailure(Call<Contact> call, Throwable t) {
                Log.i("onFailure Retrofit", t.getMessage());
                Log.i("Contact Deleted", " ");
            }
        });
    }
}
