package com.yn.customsection;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * created by：TangTao on 2019/2/19 15:32
 * <p>
 * email：xxx@163.com
 */
public class CustomSectionView extends RelativeLayout {

    private ImageView ivLeft;
    private ImageView ivRight;
    private TextView tvContent;
    private RelativeLayout rel_layout;
    private int mbgColor;
    private int mTextColor;
    private String mContentText;
    private int mImgLeft;
    private int mImgRight;


    public CustomSectionView(Context context) {
        this(context,null);
        initView(context);
    }

    public CustomSectionView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
        initView(context);
    }

    public CustomSectionView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initTypedArray(context, attrs);
        initView(context);

    }

    private void initTypedArray(Context context, AttributeSet attrs) {

        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.CustomSectionView);
        mbgColor = array.getColor(R.styleable.CustomSectionView_section_view_bg, Color.WHITE);
        mTextColor = array.getColor(R.styleable.CustomSectionView_tex_color, Color.GRAY);
        mContentText = array.getString(R.styleable.CustomSectionView_tex);
        mImgLeft=array.getResourceId(R.styleable.CustomSectionView_left_img,R.drawable.food);
        mImgRight=array.getResourceId(R.styleable.CustomSectionView_right_img,R.drawable.arrow);
        //获取完资源要及时回收
        array.recycle();


    }

    private void initView(Context context) {

        LayoutInflater.from(context).inflate(R.layout.custom_section, this, true);
        ivLeft = findViewById(R.id.iv_icon_left);
        ivRight = findViewById(R.id.iv_arrow_right);
        tvContent = findViewById(R.id.tv_content);
        rel_layout = findViewById(R.id.rel_layout);
        rel_layout.setBackgroundColor(mbgColor);
        tvContent.setTextColor(mTextColor);
        setTextContent(mContentText);
        setIvLeft(mImgLeft);
        setIvRight(mImgRight);

    }

    public void setIvLeft(int imgLeft) {
        if (ivLeft != null ) {
            ivLeft.setImageResource(imgLeft);
        }
    }

    public void setIvRight(int imgRight) {
        if (ivRight != null ) {
            ivRight.setImageResource(imgRight);
        }
    }


    public void setTextContent(String content) {
        if (!TextUtils.isEmpty(content)) {
            tvContent.setText(content);
        }
    }

    public void setTextContent(int stringId) {
        if (!TextUtils.isEmpty(getResources().getString(stringId))) {
            tvContent.setText(stringId);
        }
    }

    public void setSectionClickListener(OnClickListener clickListener) {
        if (clickListener != null) {
            rel_layout.setOnClickListener(clickListener);
        }
    }
}
