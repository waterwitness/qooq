package com.tencent.mobileqq.portal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import tuj;

public class PrepareView
  extends RelativeLayout
{
  private Context jdField_a_of_type_AndroidContentContext;
  private CountDownTimer jdField_a_of_type_AndroidOsCountDownTimer;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private FlakeView jdField_a_of_type_ComTencentMobileqqPortalFlakeView;
  private boolean jdField_a_of_type_Boolean;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private TextView h;
  private TextView i;
  
  public PrepareView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a(paramContext);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a();
    }
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null) {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
    }
    this.jdField_a_of_type_AndroidOsCountDownTimer = new tuj(this, paramLong, 1000L);
    this.jdField_a_of_type_AndroidOsCountDownTimer.start();
  }
  
  public void a(Context paramContext)
  {
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    LayoutInflater.from(paramContext).inflate(2130904188, this, true);
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131300338));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131301764));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301766));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131301768));
    this.c = ((TextView)findViewById(2131301767));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131301756));
    this.d = ((TextView)findViewById(2131301757));
    this.e = ((TextView)findViewById(2131301759));
    this.f = ((TextView)findViewById(2131301761));
    this.g = ((TextView)findViewById(2131301763));
    this.h = ((TextView)findViewById(2131301758));
    this.i = ((TextView)findViewById(2131301762));
    paramContext = Typeface.createFromAsset(paramContext.getAssets(), "fonts/DS-DIGIB.TTF");
    this.jdField_a_of_type_AndroidWidgetTextView.setTypeface(paramContext);
    this.jdField_b_of_type_AndroidWidgetTextView.setTypeface(paramContext);
    this.c.setTypeface(paramContext);
    this.d.setTypeface(paramContext);
    this.e.setTypeface(paramContext);
    this.f.setTypeface(paramContext);
    this.g.setTypeface(paramContext);
    this.h.setTypeface(paramContext);
    this.i.setTypeface(paramContext);
  }
  
  /* Error */
  public void a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aload_0
    //   4: getfield 55	com/tencent/mobileqq/portal/PrepareView:jdField_a_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   7: bipush 8
    //   9: invokevirtual 53	android/widget/RelativeLayout:setVisibility	(I)V
    //   12: aload_0
    //   13: getfield 49	com/tencent/mobileqq/portal/PrepareView:jdField_b_of_type_AndroidWidgetRelativeLayout	Landroid/widget/RelativeLayout;
    //   16: iconst_0
    //   17: invokevirtual 53	android/widget/RelativeLayout:setVisibility	(I)V
    //   20: aload_1
    //   21: invokestatic 156	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   24: ifne +91 -> 115
    //   27: aload_1
    //   28: invokevirtual 162	java/lang/String:length	()I
    //   31: istore 7
    //   33: aload_1
    //   34: iconst_0
    //   35: iconst_2
    //   36: invokevirtual 166	java/lang/String:substring	(II)Ljava/lang/String;
    //   39: astore_3
    //   40: aload_1
    //   41: iconst_3
    //   42: iconst_5
    //   43: invokevirtual 166	java/lang/String:substring	(II)Ljava/lang/String;
    //   46: astore_2
    //   47: aload_1
    //   48: iload 7
    //   50: iconst_5
    //   51: isub
    //   52: iload 7
    //   54: iconst_3
    //   55: isub
    //   56: invokevirtual 166	java/lang/String:substring	(II)Ljava/lang/String;
    //   59: astore 4
    //   61: aload_1
    //   62: iload 7
    //   64: iconst_2
    //   65: isub
    //   66: iload 7
    //   68: invokevirtual 166	java/lang/String:substring	(II)Ljava/lang/String;
    //   71: astore_1
    //   72: aload_3
    //   73: astore 6
    //   75: aload 4
    //   77: astore 5
    //   79: aload_1
    //   80: astore_3
    //   81: aload_0
    //   82: getfield 114	com/tencent/mobileqq/portal/PrepareView:d	Landroid/widget/TextView;
    //   85: aload 6
    //   87: invokevirtual 170	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   90: aload_0
    //   91: getfield 117	com/tencent/mobileqq/portal/PrepareView:e	Landroid/widget/TextView;
    //   94: aload_2
    //   95: invokevirtual 170	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   98: aload_0
    //   99: getfield 120	com/tencent/mobileqq/portal/PrepareView:f	Landroid/widget/TextView;
    //   102: aload 5
    //   104: invokevirtual 170	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   107: aload_0
    //   108: getfield 123	com/tencent/mobileqq/portal/PrepareView:g	Landroid/widget/TextView;
    //   111: aload_3
    //   112: invokevirtual 170	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
    //   115: return
    //   116: astore_3
    //   117: aconst_null
    //   118: astore_2
    //   119: aconst_null
    //   120: astore 4
    //   122: aconst_null
    //   123: astore_1
    //   124: aload_3
    //   125: invokevirtual 173	java/lang/IndexOutOfBoundsException:printStackTrace	()V
    //   128: aload 6
    //   130: astore_3
    //   131: aload_1
    //   132: astore 5
    //   134: aload 4
    //   136: astore 6
    //   138: goto -57 -> 81
    //   141: astore 5
    //   143: aconst_null
    //   144: astore_2
    //   145: aconst_null
    //   146: astore_1
    //   147: aload_3
    //   148: astore 4
    //   150: aload 5
    //   152: astore_3
    //   153: goto -29 -> 124
    //   156: astore 5
    //   158: aconst_null
    //   159: astore_1
    //   160: aload_3
    //   161: astore 4
    //   163: aload 5
    //   165: astore_3
    //   166: goto -42 -> 124
    //   169: astore 5
    //   171: aload 4
    //   173: astore_1
    //   174: aload_3
    //   175: astore 4
    //   177: aload 5
    //   179: astore_3
    //   180: goto -56 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	PrepareView
    //   0	183	1	paramString	String
    //   46	99	2	str1	String
    //   39	73	3	str2	String
    //   116	9	3	localIndexOutOfBoundsException1	IndexOutOfBoundsException
    //   130	50	3	localObject1	Object
    //   59	117	4	localObject2	Object
    //   77	56	5	localObject3	Object
    //   141	10	5	localIndexOutOfBoundsException2	IndexOutOfBoundsException
    //   156	8	5	localIndexOutOfBoundsException3	IndexOutOfBoundsException
    //   169	9	5	localIndexOutOfBoundsException4	IndexOutOfBoundsException
    //   1	136	6	localObject4	Object
    //   31	36	7	j	int
    // Exception table:
    //   from	to	target	type
    //   33	40	116	java/lang/IndexOutOfBoundsException
    //   40	47	141	java/lang/IndexOutOfBoundsException
    //   47	61	156	java/lang/IndexOutOfBoundsException
    //   61	72	169	java/lang/IndexOutOfBoundsException
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView = new FlakeView(this.jdField_a_of_type_AndroidContentContext, false);
      addView(this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView, 0, new RelativeLayout.LayoutParams(-1, -1));
      this.jdField_a_of_type_Boolean = true;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalFlakeView.a(false);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_AndroidOsCountDownTimer != null)
    {
      this.jdField_a_of_type_AndroidOsCountDownTimer.cancel();
      this.jdField_a_of_type_AndroidOsCountDownTimer = null;
    }
  }
  
  public void setBackground(Bitmap paramBitmap1, Bitmap paramBitmap2)
  {
    if (paramBitmap1 != null)
    {
      Drawable localDrawable = this.jdField_a_of_type_AndroidWidgetImageView.getDrawable();
      if ((localDrawable == null) || (!(localDrawable instanceof BitmapDrawable)) || (((BitmapDrawable)localDrawable).getBitmap() != paramBitmap1)) {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramBitmap1);
      }
    }
    for (;;)
    {
      if (paramBitmap2 != null) {}
      try
      {
        paramBitmap1 = getBackground();
        if ((paramBitmap1 != null) && ((paramBitmap1 instanceof BitmapDrawable)))
        {
          paramBitmap1 = ((BitmapDrawable)paramBitmap1).getBitmap();
          if (paramBitmap1 == paramBitmap2)
          {
            return;
            this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130840804);
            continue;
          }
        }
        super.setBackgroundDrawable(new BitmapDrawable(getResources(), paramBitmap2));
        return;
      }
      catch (Throwable paramBitmap1) {}
    }
    super.setBackgroundResource(2130840753);
    return;
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\com\tencent\mobileqq\portal\PrepareView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */