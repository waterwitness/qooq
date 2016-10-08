package cooperation.qwallet.plugin;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;

public class QWalletLoadingDialog
  extends Dialog
{
  Context jdField_a_of_type_AndroidContentContext = null;
  Animatable jdField_a_of_type_AndroidGraphicsDrawableAnimatable = null;
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  protected boolean a;
  protected boolean b = true;
  
  protected QWalletLoadingDialog(Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext, paramInt);
    this.jdField_a_of_type_Boolean = paramBoolean;
    a(paramContext);
  }
  
  public QWalletLoadingDialog(Context paramContext, boolean paramBoolean)
  {
    this(paramContext, 2131558971, paramBoolean);
    paramBoolean = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  protected void a(Context paramContext)
  {
    if ((this.jdField_a_of_type_Boolean) && ((paramContext instanceof BaseActivity)))
    {
      localObject = (BaseActivity)paramContext;
      this.b = ((BaseActivity)localObject).getCanLock();
      ((BaseActivity)localObject).setCanLock(false);
    }
    super.requestWindowFeature(1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    Object localObject = getWindow();
    paramContext = LayoutInflater.from(paramContext).inflate(2130904638, null);
    setContentView(paramContext);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      ((Window)localObject).addFlags(67108864);
      new SystemBarCompact(this, true, this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131428295)).init();
      paramContext.setFitsSystemWindows(true);
      paramContext.setPadding(0, ImmersiveUtils.a(this.jdField_a_of_type_AndroidContentContext), 0, 0);
    }
    WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
    localLayoutParams.width = -1;
    localLayoutParams.height = -1;
    ((Window)localObject).setAttributes(localLayoutParams);
    setCanceledOnTouchOutside(false);
    localObject = (TextView)paramContext.findViewById(2131297083);
    if (localObject != null)
    {
      ((TextView)localObject).setVisibility(0);
      ((TextView)localObject).setText(2131367975);
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramContext.findViewById(2131297139));
    if (this.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131366450);
    }
    paramContext = (ImageView)paramContext.findViewById(2131303411);
    if (paramContext != null)
    {
      paramContext.setVisibility(0);
      paramContext.setImageResource(2130843168);
    }
    paramContext = (ImageView)super.findViewById(2131303413);
    localObject = new TranslateAnimation(1, -1.0F, 2, 1.0F, 1, 0.0F, 1, 0.0F);
    ((TranslateAnimation)localObject).setDuration(3000L);
    ((TranslateAnimation)localObject).setRepeatCount(-1);
    paramContext.startAnimation((Animation)localObject);
    super.setCancelable(false);
  }
  
  public void dismiss()
  {
    super.dismiss();
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_AndroidContentContext instanceof BaseActivity)))
    {
      ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).setCanLock(this.b);
      BaseActivity.isUnLockSuccess = true;
    }
    if (this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable != null) {
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838325));
    if ((this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable != null) && (this.jdField_a_of_type_AndroidWidgetTextView != null))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablePadding(10);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable, null, null, null);
      this.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.start();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes2-dex2jar.jar!\cooperation\qwallet\plugin\QWalletLoadingDialog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */