package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import java.util.ArrayList;

public class ViewFactory$GuideView
  extends LinearLayout
  implements View.OnClickListener
{
  public static final int a = 3;
  public ViewFactory.GuideView.OnItemClickListener a;
  private int b;
  
  public ViewFactory$GuideView(Context paramContext)
  {
    super(paramContext);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.b = -1;
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    setOrientation(1);
    paramContext = LayoutInflater.from(paramContext);
    int i = 0;
    while (i < 3)
    {
      addView(paramContext.inflate(2130903068, this, false));
      i += 1;
    }
  }
  
  private void a(String paramString)
  {
    int j = getChildCount();
    int i = 0;
    if (i < j)
    {
      View localView = getChildAt(i);
      localView.setTag(((Integer)localView.getTag()).intValue(), paramString);
      ((TextView)localView.findViewById(2131296914)).setText(paramString);
      String str = localView.getContentDescription().toString();
      int k = str.length();
      int m = str.indexOf(":");
      if ((m == -1) || (m == k - 1)) {}
      for (;;)
      {
        i += 1;
        break;
        localView.setContentDescription(str.substring(0, m + 1) + paramString);
      }
    }
  }
  
  private void a(ArrayList paramArrayList, String paramString)
  {
    int j = getChildCount();
    int i = 0;
    while (i < j)
    {
      View localView = getChildAt(i);
      localView.setOnClickListener(this);
      localView.setTag(Integer.valueOf(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).b));
      localView.setTag(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).b, paramString);
      ((ImageView)localView.findViewById(2131296912)).setImageResource(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).b);
      ((TextView)localView.findViewById(2131296913)).setText(localView.getContext().getResources().getString(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).a) + ":");
      ((TextView)localView.findViewById(2131296914)).setText(paramString);
      localView.setContentDescription(getResources().getString(((ViewFactory.GuideView.DataHolder)paramArrayList.get(i)).a) + ":" + paramString);
      i += 1;
    }
  }
  
  public ViewFactory.GuideView.DataHolder a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 80000000: 
      return new ViewFactory.GuideView.DataHolder(2131368610, 2130840509);
    case 80000001: 
      return new ViewFactory.GuideView.DataHolder(2131368611, 2130840510);
    }
    return new ViewFactory.GuideView.DataHolder(2131368612, 2130840511);
  }
  
  public ViewFactory.GuideView.OnItemClickListener a()
  {
    return this.a;
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.b != paramInt)
    {
      ArrayList localArrayList = new ArrayList(3);
      int[] arrayOfInt = ViewFactory.a(paramInt);
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        localArrayList.add(a(arrayOfInt[i]));
        i += 1;
      }
      this.b = paramInt;
      a(localArrayList, paramString);
      return;
    }
    a(paramString);
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = (String)paramView.getTag(i);
    switch (i)
    {
    }
    for (;;)
    {
      if (this.a != null) {
        this.a.a(i, paramView);
      }
      return;
      i = 80000000;
      continue;
      i = 80000001;
      continue;
      i = 80000002;
    }
  }
  
  public void setListener(ViewFactory.GuideView.OnItemClickListener paramOnItemClickListener)
  {
    this.a = paramOnItemClickListener;
  }
}


/* Location:              E:\apk\QQ_91\classes-dex2jar.jar!\com\tencent\mobileqq\activity\contact\addcontact\ViewFactory$GuideView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */