package com.bagicode.www.chatku;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;

import com.bagicode.www.chatku._adapter.RecyclerTouchListener;
import com.bagicode.www.chatku._adapter.UserAdapter;
import com.bagicode.www.chatku._model.item_user;

import java.util.ArrayList;
import java.util.List;

public class UserActivity extends AppCompatActivity {

    private List<item_user> itemproductList = new ArrayList<>();
    private RecyclerView recyclerView;
    private UserAdapter mAdapter;
    private item_user itemproduct;

    private Paint p = new Paint();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new UserAdapter(itemproductList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(),
                recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                item_user itemproduct = itemproductList.get(position);

                if(itemproduct.getTitle().equals("Robby Dianputra")) {
                    Intent goDetailActivity = new Intent(UserActivity.this, ChatActivity.class);
                    startActivity(goDetailActivity);
                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

//        setRecyclerViewItemTouchListener();
//        getLaporan("3");
        prepareMovieData();
    }

    private void prepareMovieData() {

        int id = getResources().getIdentifier("ic_user", "drawable", getPackageName());
        item_user itemproduct = new item_user("Robby Dianputra", id);
        itemproductList.add(itemproduct);


        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    //    public void getLaporan(final String status){
//
//        String tag_string_req = "req_lapor";
//        String URL_GET_LAPOR = "https://pilkada2017.kpu.go.id/api/2/hasil.json";
//
//        StringRequest strReq = new StringRequest(Request.Method.GET,
//                URL_GET_LAPOR , new Response.Listener<String>() {
//
//            @Override
//            public void onResponse(String response) {
//
//
//                try {
//                    JSONArray jObj = new JSONArray(response);
//
//                        Log.i("error response", "==> wow " + jObj.toString());
//
//                    String NoLPrespones, namaPemilihan, namaWilayah, namaPropinsi, namaKd, namaWkd;
//                    int idWilayah, nomorUrut, jumlahSuara;
//                    JSONObject jObjRespone;
//
//                    for (int a=0; a< jObj.length(); a++){
//                         NoLPrespones = jObj.getString(a);
//                         jObjRespone = new JSONObject(NoLPrespones);
//                         idWilayah = jObjRespone.getInt("idWilayah");
//                         nomorUrut = jObjRespone.getInt("nomorUrut");
//                         jumlahSuara = jObjRespone.getInt("jumlahSuara");
//                         namaPemilihan = jObjRespone.getString("namaPemilihan");
//                         namaWilayah = jObjRespone.getString("namaWilayah");
//                         namaPropinsi = jObjRespone.getString("namaPropinsi");
//                         namaKd = jObjRespone.getString("namaKd");
//                         namaWkd = jObjRespone.getString("namaWkd");
//
//                        movie = new Movie("Nomor Urut : "+String.valueOf(nomorUrut),
//                                "Suara : "+String.valueOf(jumlahSuara),
//                                namaWilayah);
//                        movieList.add(movie);
//                    }
//                        Log.i("error response", "==> " + movieList.toString());
//                        mAdapter.notifyDataSetChanged();
//
//                } catch (JSONException e) {
//                    // JSON error
//                    e.printStackTrace();
//                    Toast.makeText(MainActivity.this, "Json error: " + e.getMessage(), Toast.LENGTH_LONG).show();
//                }
//
//            }
//        }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                Toast.makeText(MainActivity.this,
//                        error.getMessage(), Toast.LENGTH_LONG).show();
//
//            }
//        });
//
//        AppController.getInstance().addToRequestQueue(strReq, tag_string_req);
//
//    }

//    private void setRecyclerViewItemTouchListener() {
//
//        ItemTouchHelper.SimpleCallback itemTouchCallback =
//                new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
//
//            @Override
//            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder1) {
//                //2
//                Toast.makeText(getApplicationContext(), movie.getTitle() + " is 2", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//
//            @Override
//            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
//                int position = viewHolder.getAdapterPosition();
//
//                //3
//                if (swipeDir == ItemTouchHelper.LEFT){
//                    Toast.makeText(getApplicationContext(), movie.getTitle() + " is Kanan "+swipeDir , Toast.LENGTH_SHORT).show();
//                    movieList.remove(position);
//                    recyclerView.getAdapter().notifyItemRemoved(position);
//                } else {
//                    Toast.makeText(getApplicationContext(), movie.getTitle() + " is Kiri "+swipeDir , Toast.LENGTH_SHORT).show();
//                    mAdapter.notifyDataSetChanged();
//                }
//            }
//
//            @Override
//            public void onChildDraw(Canvas c, RecyclerView recyclerView,
//                                    RecyclerView.ViewHolder viewHolder, float dX, float dY,
//                                    int actionState, boolean isCurrentlyActive) {
//
//                Bitmap icon;
//                if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
//
//                    View itemView = viewHolder.itemView;
//                    float height = (float) itemView.getBottom() - (float) itemView.getTop();
//                    float width = height / 3;
//
//                    if (dX > 0) {
//                        p.setColor(Color.parseColor("#388E3C"));
//                        RectF background = new RectF((float) itemView.getLeft(),
//                                (float) itemView.getTop(), dX, (float) itemView.getBottom());
//                        c.drawRect(background, p);
//                        icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_edit_white);
//                        RectF icon_dest = new RectF((float) itemView.getLeft() + width,
//                                (float) itemView.getTop() + width,
//                                (float) itemView.getLeft() + 2 * width,
//                                (float) itemView.getBottom() - width);
//                        c.drawBitmap(icon, null, icon_dest, p);
//
//                    } else {
//                        p.setColor(Color.parseColor("#D32F2F"));
//                        RectF background = new RectF((float) itemView.getRight() + dX,
//                                (float) itemView.getTop(), (float) itemView.getRight(), (float) itemView.getBottom());
//                        c.drawRect(background, p);
//                        icon = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_delete_white);
//                        RectF icon_dest = new RectF((float) itemView.getRight() - 2 * width,
//                                (float) itemView.getTop() + width,
//                                (float) itemView.getRight() - width,
//                                (float) itemView.getBottom() - width);
//                        c.drawBitmap(icon, null, icon_dest, p);
//                    }
//                }
//                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
//            }
//
//
//        };
//
//        //4
//        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchCallback);
//        itemTouchHelper.attachToRecyclerView(recyclerView);
//    }

}