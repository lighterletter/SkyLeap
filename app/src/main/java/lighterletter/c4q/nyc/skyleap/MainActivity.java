package lighterletter.c4q.nyc.skyleap;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import lighterletter.c4q.nyc.skyleap.tabs.SlidingTabLayout;


public class MainActivity extends AppCompatActivity { /* When using Appcombat support library
                                                         you need to extend Main Activity to
                                                         ActionBarActivity.
                                                      */
     Toolbar toolbar;                              // Declaring the Toolbar Object
     ViewPager mViewPager;
     ViewPagerAdapter adapter;
     SlidingTabLayout tabs;
     CharSequence Titles[]={"Weather","Space","ToDo"};
     int Numboftabs = 3;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar) findViewById(R.id.tool_bar); // Attaching the layout to the toolbar object
        setSupportActionBar(toolbar);                   // Setting toolbar as the Active ActionBar with setSupportActionBar() call

        // Creating The ViewPagerAdapter which will combine and arrange the necessary elements.
        // passing a request of three arguments to receive Fragment Manager support, Titles array,  and Number Of Tabs.
        // Since we wrote the code, we can give it instructions before we actually create it programmatically which will
        // trigger the compiled code.
        adapter = new ViewPagerAdapter(getSupportFragmentManager(),Titles,Numboftabs);//

        //// Assigning ViewPager View and setting the adapter
        /*from the docs: ViewPager: Layout manager that allows the user to flip left and right through pages of data.
        You supply an implementation of a PagerAdapter to generate the pages that the view shows.*/
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mViewPager.setAdapter(adapter);

        // Assigning the Sliding Tab Layout View
        tabs = (SlidingTabLayout) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true); // To make the Tabs Fixed set this true, This makes the tabs Space Evenly in Available width


// Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                return getResources().getColor(R.color.light_overlay);
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(mViewPager);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}