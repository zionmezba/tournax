//package com.tournax.pck;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.view.WindowManager;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class AboutUs extends AppCompatActivity {
//
//    com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager = (com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager)findViewById(R.id.view_pager);
//    List<Names> namesList = new ArrayList<>();
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        setContentView(R.layout.activity_about_us);
//
//        initdata();
//
//        viewpagerHorizon = (com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager)findViewById(R.id.view_pager);
//        AdapterAbout adapterAbout = new AdapterAbout(this,namesList);
//        viewpagerHorizon.setAdapter(adapterAbout);
//    }
//
//    private void initdata() {
//        namesList.add(new Names("Md. Mezbaul Islam Zion","Hi,\nI'm Md. Mezbaul Islam Zion.\nI'm studying Computer Science and Engineering in Daffodil International University. I worked as a Developer of TournaX app.\n\nID: 201-15-3496\nSection: PC-K\nTeam TournaX",R.drawable.zion_pic1));
//        namesList.add(new Names("Sudipto Paul","Hi,\nI am Sudipto Paul. My university is Daffodil International University & department is CSE. As a big fan of Esports we developed TournaX.\n\nID: 201-15-3478\nSection: PC-K\nTeam TournaX",R.drawable.sudipto_pic2));
//        namesList.add(new Names("Md. Rasheduzzaman Elite","Hi,\nI am Rasheduzzaman Elite. I am studying in department of CSE at Daffodil International University. I am a developer of TournaX. For any query, contact with me on whatsapp 01755926275.\n\nID: 201-15-3235\nSection: PC-K\nTeam TournaX",R.drawable.elite_pic4));
//        namesList.add(new Names("Sheikh Badrun Nesa Lubna","Hi,\nI'm Lubna. I am studying at Daffodil International University in the CSE department.  I am interested in working as an app developer. I have worked on the Tournax project.\n\nID: 201-15-3590\nSection: PC-K\nTeam TournaX",R.drawable.lubna_pic3));
//        namesList.add(new Names("Tawfiqur Rahman Moin","Hi,\nI am Tawfikur Rahman Moin.I am studying in Daffodil international University at CSE department. I like to think of something new,that's why we developed a new Project - TournaX.\n\nID: 201-15-3103\nSection: PC-K\nTeam TournaX",R.drawable.moin_pic6));
//        namesList.add(new Names("Sabriar Bishal","Hi,\nI'm Sabria Bishal. I am studying in Daffodil International University at department of CSE. I'm a developer of Tournax. I like helping the poor because they also a man like us.\n\nID: 201-15-3143\nSection: PC-K\nTeam TournaX",R.drawable.bishal_pic5));
//        namesList.add(new Names("Esports","Esports is a form of sport competition using video games. With continual innovation and growth, the possibilities for eSports are endless. There is no doubt that local lockdowns across the world increased the awareness of esports but year on year growth was already happening. We hope our project TournaX will give it a step forward",R.drawable.esports));
//    }
//}