package com.example.esraabalbaa.graduationproject;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.esraabalbaa.graduationproject.DrawerFragments.OffersFragment;
import com.example.esraabalbaa.graduationproject.MainFragments.Categories;
import com.example.esraabalbaa.graduationproject.MainFragments.CustomFragmentPageAdapter;
import com.example.esraabalbaa.graduationproject.MainFragments.Favourites;
import com.example.esraabalbaa.graduationproject.MainFragments.Home;
import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,Home.OnFragmentInteractionListener,
        Favourites.OnFragmentInteractionListener,Categories.OnFragmentInteractionListener  ,
        OffersFragment.OnFragmentInteractionListener{
    private TabLayout tabLayout;
    private ViewPager viewPager;
    ImageView cartimg;
    AlertDialog ad;
    private Button logout;
    de.hdodenhof.circleimageview.CircleImageView circleview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(this);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        //facebook

//        Bitmap bmap = this.getIntent().getParcelableExtra("Bitmap");
        circleview = (de.hdodenhof.circleimageview.CircleImageView) findViewById(R.id.civ);
//        circleview.setImageBitmap(bmap);
//        Bundle inBundle = getIntent().getExtras();
//        String name = inBundle.get("name").toString();
//        String surname = inBundle.get("surname").toString();
//        String imageUrl = inBundle.get("imageUrl").toString();

        TextView nameView = (TextView) findViewById(R.id.uname);
//        nameView.setText("" + name + " " + surname);
//        Button logout = (Button) findViewById(R.id.logout);
//        logout.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View view){
//                LoginManager.getInstance().logOut();
//                Intent login = new Intent(MainActivity.this, LoginActivity.class);
//                startActivity(login);
//                finish();
//            }
//        });
//        new MainActivity.DownloadImage((ImageView)findViewById(R.id.civ)).execute(imageUrl);

        cartimg = (ImageView) findViewById(R.id.cart);
        cartimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,CartActivity.class);
                startActivity(i);
            }
        });

        viewPager = (ViewPager) findViewById(R.id.view_pager);
        CustomFragmentPageAdapter fadapter = new CustomFragmentPageAdapter(getSupportFragmentManager());
     fadapter.fragmentadd(new Home(), "Home");
        fadapter.fragmentadd(new Categories(), "Categories");
        fadapter.fragmentadd(new Favourites(), "Favourites");
        viewPager.setAdapter(fadapter);
        tabLayout.setupWithViewPager(viewPager);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //SNACKBAR
    }
    //facebook

//    public class DownloadImage extends AsyncTask<String, Void, Bitmap> {
//        ImageView bmImage;
//
//        public DownloadImage(ImageView bmImage){
//            this.bmImage = bmImage;
//        }
//
//        protected Bitmap doInBackground(String... urls){
//            String urldisplay = urls[0];
//            Bitmap mIcon11 = null;
//            try{
//                InputStream in = new java.net.URL(urldisplay).openStream();
//                mIcon11 = BitmapFactory.decodeStream(in);
//            }catch (Exception e){
//                Log.e("Error", e.getMessage());
//                e.printStackTrace();
//            }
//            return mIcon11;
//        }
//
//        protected void onPostExecute(Bitmap result){
//            bmImage.setImageBitmap(result);
//        }
//
//    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
//         AlertDialog.Builder bu = new AlertDialog.Builder(MainActivity.this);
//        bu.setTitle("Exit App");
//        bu.setMessage("هل تريد اغلاق البرنامج؟");
//        bu.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                finish();
//            }
//        });
//        bu.setNegativeButton("لا", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                dialogInterface.dismiss();
//            }
//        });
//        AlertDialog ad = bu.create();
//        ad.show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
//    FragmentManager fm = getFragmentManager();

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.homepage) {

            Intent h = new Intent(MainActivity.this,MainActivity.class);
            startActivity(h);


        }   else if (id == R.id.custprofile) {
            Intent i = new Intent(MainActivity.this,CustomerProfile.class);
            startActivity(i);


        }  else if (id == R.id.offers) {
            OffersFragment fragment = new OffersFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container,fragment).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFavouritesFragmentInteraction(Uri uri) {

    }

    @Override
    public void onHomeFragmentInteraction(Uri uri) {

    }

    @Override
    public void onCategoriesFragmentInteraction(Uri uri) {

    }
}

