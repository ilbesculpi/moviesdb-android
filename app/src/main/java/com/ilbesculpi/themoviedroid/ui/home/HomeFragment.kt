package com.ilbesculpi.themoviedroid.ui.home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.ilbesculpi.themoviedroid.R
import com.ilbesculpi.themoviedroid.domain.models.Category
import com.ilbesculpi.themoviedroid.domain.models.Section
import com.ilbesculpi.themoviedroid.ui.common.BaseFragmentView
import javax.inject.Inject


/**
 * Home screen.
 * It displays the list of categories (Popular, Top Rated, Upcoming) for movies or tv shows.
 */
class HomeFragment : BaseFragmentView(), Home.View {

    @Inject
    lateinit override var presenter: Home.Presenter;
    
    lateinit var section: Section;
    
    lateinit private var listView: ListView;
    
    companion object {
        
        fun newInstance(section: Section) : HomeFragment {
            val fragment = HomeFragment();
            val args = Bundle();
            args.putSerializable("section", section);
            fragment.arguments = args;
            return fragment;
        }
        
    }
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        if( arguments != null ) {
            section = arguments.getSerializable("section") as Section;
        }
        configureComponents();
    }
    
    override fun configureComponents() {
        appComponent.inject(this);
        presenter.section = section;
        presenter.view = this;
    }
    
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater!!.inflate(R.layout.home_layout, container, false);
        listView = view.findViewById<ListView>(android.R.id.list);
        return view;
    }
    
    override fun onStart() {
        super.onStart();
        presenter.onStart();
    }
    
    override fun onStop() {
        presenter.onStop();
        super.onStop();
    }
    
    override fun onResume() {
        super.onResume();
        presenter.onResume();
    }
    
    override fun onPause() {
        presenter.onPause();
        super.onPause();
    }
    
    override fun displayCategories(categories: List<Category>) {
        val adapter = CategoryListAdapter(context, R.layout.category_list_item, categories);
        listView.adapter = adapter;
    }

}
