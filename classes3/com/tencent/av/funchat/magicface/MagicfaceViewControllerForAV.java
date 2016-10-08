package com.tencent.av.funchat.magicface;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import gho;
import ghq;
import org.json.JSONException;

public class MagicfaceViewControllerForAV
  implements View.OnClickListener
{
  public static final int a = 0;
  private static MagicfaceViewControllerForAV a;
  public static final String a = "MagicfaceViewControllerForAV";
  public static final int b = 1;
  public static final int c = 2;
  public Handler a;
  protected ViewGroup a;
  protected WindowManager a;
  protected Button a;
  protected RelativeLayout a;
  public IMagicFaceViewForAV a;
  public MagicfacePlayer a;
  public MagicfaceViewControllerForAV.OnMagicPlayEnd a;
  public boolean a;
  public ViewGroup b;
  protected MagicfaceViewControllerForAV.OnMagicPlayEnd b;
  protected String b;
  public boolean b;
  public String c;
  protected boolean c;
  protected int d;
  
  private MagicfaceViewControllerForAV()
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.d = 0;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    a();
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewControllerForAV", 2, "func MagicfaceViewController[Constructor] ends.isUseHardDecode:" + this.jdField_c_of_type_Boolean);
    }
  }
  
  public static MagicfaceViewControllerForAV a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV == null) {
        jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV = new MagicfaceViewControllerForAV();
      }
      return jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV;
    }
    finally {}
  }
  
  private void a()
  {
    this.jdField_c_of_type_Boolean = false;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewControllerForAV", 2, "initMagicfaceView begins");
    }
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null)
    {
      View localView = View.inflate(BaseApplicationImpl.getContext(), 2130903578, null);
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localView.findViewById(2131299313));
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceIMagicFaceViewForAV = ((IMagicFaceViewForAV)localView.findViewById(2131299314));
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131299315));
    }
    if (QLog.isColorLevel()) {
      QLog.d("MagicfaceViewControllerForAV", 2, "initMagicfaceView ends");
    }
  }
  
  public int a()
  {
    return this.d;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  /* Error */
  public String a(String paramString)
  {
    // Byte code:
    //   0: new 131	java/io/FileInputStream
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 134	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   8: astore_2
    //   9: aload_2
    //   10: invokevirtual 137	java/io/FileInputStream:available	()I
    //   13: newarray <illegal type>
    //   15: astore_1
    //   16: aload_2
    //   17: aload_1
    //   18: invokevirtual 141	java/io/FileInputStream:read	([B)I
    //   21: pop
    //   22: new 143	java/lang/String
    //   25: dup
    //   26: aload_1
    //   27: ldc -111
    //   29: invokespecial 148	java/lang/String:<init>	([BLjava/lang/String;)V
    //   32: astore_1
    //   33: aload_2
    //   34: invokevirtual 151	java/io/FileInputStream:close	()V
    //   37: aload_1
    //   38: areturn
    //   39: astore_2
    //   40: ldc -103
    //   42: astore_1
    //   43: aload_0
    //   44: ldc -101
    //   46: invokevirtual 157	com/tencent/av/funchat/magicface/MagicfaceViewControllerForAV:b	(Ljava/lang/String;)V
    //   49: aload_2
    //   50: invokevirtual 160	java/lang/Exception:printStackTrace	()V
    //   53: aload_1
    //   54: areturn
    //   55: astore_2
    //   56: goto -13 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	59	0	this	MagicfaceViewControllerForAV
    //   0	59	1	paramString	String
    //   8	26	2	localFileInputStream	java.io.FileInputStream
    //   39	11	2	localException1	Exception
    //   55	1	2	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	33	39	java/lang/Exception
    //   33	37	55	java/lang/Exception
  }
  
  public void a(ViewGroup paramViewGroup, String paramString, MagicfaceViewControllerForAV.OnMagicPlayEnd paramOnMagicPlayEnd, boolean paramBoolean)
  {
    if ((paramViewGroup == null) || (paramString == null)) {
      b("func playMaigcface ends, step 0.");
    }
    for (;;)
    {
      return;
      if (a(0))
      {
        this.jdField_b_of_type_AndroidViewViewGroup = paramViewGroup;
        this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV$OnMagicPlayEnd = paramOnMagicPlayEnd;
        this.jdField_c_of_type_JavaLangString = paramString;
        this.jdField_a_of_type_Boolean = paramBoolean;
        b("func playMaigcface ends, step 1.");
        return;
      }
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV$OnMagicPlayEnd = null;
      this.jdField_c_of_type_JavaLangString = null;
      this.jdField_b_of_type_AndroidViewViewGroup = null;
      this.jdField_a_of_type_Boolean = false;
      this.d = 0;
      this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
      this.jdField_b_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV$OnMagicPlayEnd = paramOnMagicPlayEnd;
      this.jdField_b_of_type_JavaLangString = paramString;
      paramOnMagicPlayEnd = EmoticonUtils.j.replace("[epId]", paramString);
      new Emoticon().epId = paramString;
      long l = System.currentTimeMillis();
      paramString = a(paramOnMagicPlayEnd + "config.json");
      try
      {
        if (!paramString.equals(""))
        {
          paramViewGroup = new MagicfaceData(paramString);
          if (paramViewGroup == null)
          {
            b("func playMaigcface ends, step 2.");
            if (this.jdField_b_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV$OnMagicPlayEnd == null) {
              continue;
            }
            this.jdField_b_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV$OnMagicPlayEnd.a();
            this.jdField_b_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV$OnMagicPlayEnd = null;
            return;
          }
        }
      }
      catch (JSONException paramViewGroup)
      {
        for (;;)
        {
          b("playMaigcface|config is not in the correct format. config = " + paramString);
          paramViewGroup = null;
          continue;
          b();
          this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfacePlayer = new MagicfacePlayer();
          paramString = new Rect();
          this.jdField_a_of_type_AndroidViewViewGroup.getWindowVisibleDisplayFrame(paramString);
          this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
          if (paramBoolean) {}
          for (int i = paramString.top;; i = 0)
          {
            paramString = new RelativeLayout.LayoutParams(-1, -1);
            paramString.topMargin = i;
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.updateViewLayout((View)this.jdField_a_of_type_ComTencentAvFunchatMagicfaceIMagicFaceViewForAV, paramString);
            paramString = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetButton.getLayoutParams();
            paramString.topMargin = (i + 20);
            this.jdField_a_of_type_AndroidWidgetButton.setLayoutParams(paramString);
            this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
            ((SurfaceView)this.jdField_a_of_type_ComTencentAvFunchatMagicfaceIMagicFaceViewForAV).setZOrderMediaOverlay(true);
            ((SurfaceView)this.jdField_a_of_type_ComTencentAvFunchatMagicfaceIMagicFaceViewForAV).getHolder().setFormat(-2);
            paramString = new gho(this, l);
            if (this.jdField_a_of_type_ComTencentAvFunchatMagicfaceIMagicFaceViewForAV.a())
            {
              a("func playMaigcface ends, step 3.");
              this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfacePlayer.a(paramOnMagicPlayEnd, null, this.jdField_a_of_type_ComTencentAvFunchatMagicfaceIMagicFaceViewForAV, paramString);
              return;
            }
            a("func playMaigcface ends, step 4.");
            this.jdField_a_of_type_ComTencentAvFunchatMagicfaceIMagicFaceViewForAV.setSurfaceCreatelistener(new ghq(this, paramOnMagicPlayEnd, paramViewGroup, paramString));
            return;
          }
          paramViewGroup = null;
        }
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.i("MagicfaceViewControllerForAV", 2, paramString);
  }
  
  public boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfacePlayer != null)
    {
      if (this.jdField_b_of_type_Boolean) {
        return true;
      }
      if (this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfacePlayer.a())
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfacePlayer.b();
        this.d = paramInt;
        b("magicfaceClose|mStopType=" + this.d + ", epid =" + this.jdField_b_of_type_JavaLangString);
        return true;
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceIMagicFaceViewForAV.setSurfaceCreatelistener(null);
      this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidWidgetRelativeLayout);
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfacePlayer.c();
      this.jdField_a_of_type_ComTencentAvFunchatMagicfaceMagicfacePlayer = null;
      if (this.jdField_b_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV$OnMagicPlayEnd != null)
      {
        this.jdField_b_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV$OnMagicPlayEnd.a();
        this.jdField_b_of_type_ComTencentAvFunchatMagicfaceMagicfaceViewControllerForAV$OnMagicPlayEnd = null;
      }
    }
    return false;
  }
  
  public void b(String paramString)
  {
    QLog.e("MagicfaceViewControllerForAV", 1, paramString);
  }
  
  public boolean b(int paramInt)
  {
    return a(paramInt);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    a(0);
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\av\funchat\magicface\MagicfaceViewControllerForAV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */