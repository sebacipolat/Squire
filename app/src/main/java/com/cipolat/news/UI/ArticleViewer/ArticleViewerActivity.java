package com.cipolat.news.UI.ArticleViewer;

import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.percent.PercentFrameLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cipolat.news.Data.Network.Model.Article;
import com.cipolat.news.Data.Network.Model.ArticleResponse;
import com.cipolat.news.Data.Network.Model.ArticleType;
import com.cipolat.news.Data.Network.Model.Author;
import com.cipolat.news.R;
import com.cipolat.news.UI.CustomView.CustomTextView;
import com.cipolat.news.Utils.DateUtils;
import com.cipolat.news.Utils.Utils;
import com.github.ybq.android.spinkit.SpinKitView;
import com.squareup.picasso.Picasso;

import org.sufficientlysecure.htmltextview.HtmlHttpImageGetter;
import org.sufficientlysecure.htmltextview.HtmlTextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

public class ArticleViewerActivity extends AppCompatActivity implements ArticleView {
    public static String ARTICLE_ITEM_ID = "ARTICLE_ITEM_ID";
    public static String ARTICLE_ITEM_TITLE = "ARTICLE_ITEM_TITLE";
    public static String ARTICLE_ITEM_COLOR_TYPE = "ARTICLE_ITEM_COLOR_TYPE";
    @Bind(R.id.divider)
    View divider;
    @Bind(R.id.moreStoriesLbl)
    CustomTextView moreStoriesLbl;
    private ArticlePresenter mArticlePresenter;

    @Bind(R.id.loader)
    SpinKitView loader;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.headerPic)
    ImageView headerPic;
    @Bind(R.id.categoryLabel)
    TextView categoryLabel;
    @Bind(R.id.autorPic)
    CircleImageView autorPic;
    @Bind(R.id.autorName)
    CustomTextView autorName;
    @Bind(R.id.datePublish)
    CustomTextView datePublish;
    @Bind(R.id.header)
    PercentFrameLayout header;
    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.app_bar_layout)
    AppBarLayout appBarLayout;
    @Bind(R.id.title)
    CustomTextView title;
    @Bind(R.id.subTitle)
    CustomTextView subTitle;
    @Bind(R.id.body)
    HtmlTextView body;
    @Bind(R.id.scroll)
    NestedScrollView scroll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_viewer);
        ButterKnife.bind(this);
        toolbar.setTitle("");
        toolbar.setNavigationIcon(ContextCompat.getDrawable(this, R.drawable.ic_arrow_back_black_24dp));
        setSupportActionBar(toolbar);
        mArticlePresenter = new ArticlePresenter(this);
        mArticlePresenter.setView(this);
        String artID = getIntent().getStringExtra(ARTICLE_ITEM_ID);
        if (artID != null) {
            mArticlePresenter.getArticle(artID);
        }
    }

    //Fill UI
    private void fillUI(ArticleResponse response) {
        Article art = response.getResponse().getContent();
        //Title
        title.setVisibility(View.VISIBLE);
        title.setText(art.getWebTitle());
        //Date
        String fecha = DateUtils.convertDateToString(DateUtils.convetDateTimeZone(art.getWebPublicationDate()));
        datePublish.setVisibility(View.VISIBLE);
        datePublish.setText(fecha);
        //imagen
        Picasso.with(this).load(art.getFields().getThumbnail()).into(headerPic);
        autorName.setVisibility(View.VISIBLE);
        //Autor
        if (art.getTags() != null && art.getTags().size() > 0) {
            Author autor = art.getTags().get(0);
            autorName.setText(Utils.firstCapital(autor.getFirstName()) + "\n" + Utils.firstCapital(autor.getLastName()));
            Picasso.with(this).load(autor.getBylineImageUrl()).placeholder(R.drawable.ic_person).error(R.drawable.ic_person).into(autorPic);
        } else {
            autorName.setText(R.string.author_notdefined);
            autorPic.setImageResource(R.drawable.ic_person);
        }
        //Type
        if (art.getSectionId() != null && !art.getSectionId().isEmpty()) {
            categoryLabel.setVisibility(View.VISIBLE);
            //avoid COMMENTISFREE
            if (art.getSectionId().toUpperCase().equals(ArticleType.COMMENTISFREE))
                categoryLabel.setText(ArticleType.COMMENTISFREE_REEPLACE);
            else
                categoryLabel.setText(art.getSectionId());

            GradientDrawable bgShape = (GradientDrawable) categoryLabel.getBackground();
            int color = ContextCompat.getColor(this, ArticleType.getColorByType(art.getSectionId().toUpperCase()));
            bgShape.setColor(color);
            bgShape.setStroke(1, color, 1, 1);
        }
        //Copete
        subTitle.setVisibility(View.VISIBLE);
        subTitle.setText(Html.fromHtml((art.getFields().getTrailText())));
        //Body
        body.setVisibility(View.VISIBLE);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/" + "Abel-Regular.ttf");
        body.setTypeface(typeface);
        body.setHtml(art.getFields().getBody(), new HtmlHttpImageGetter(body));
        //Divider
        divider.setVisibility(View.VISIBLE);
        moreStoriesLbl.setVisibility(View.VISIBLE);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.article_view_menu, menu);
        return true;
    }

    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }

    @Override
    public void onArticleResponse(ArticleResponse response) {
        loader.setVisibility(View.GONE);
        fillUI(response);
    }

    @Override
    public void onResponseFail() {

    }
}
