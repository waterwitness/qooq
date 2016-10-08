package com.tencent.mobileqq.freshnews;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.widget.EditText;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.mobileqq.troop.activity.TroopBarPublishUtils;
import sog;
import soh;

public class BlockableEditTextView
  extends EditText
{
  public static final int a = 0;
  public static final int b = 1;
  public static final int c = 2;
  private boolean a;
  int d;
  int e;
  private int f;
  
  public BlockableEditTextView(Context paramContext)
  {
    super(paramContext);
    this.f = 0;
    this.d = -1;
    this.e = -1;
    a();
  }
  
  public BlockableEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.f = 0;
    this.d = -1;
    this.e = -1;
    a();
  }
  
  public BlockableEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
    this.f = 0;
    this.d = -1;
    this.e = -1;
    a();
  }
  
  private void a()
  {
    setEditableFactory(TroopBarPublishUtils.a);
    if (Build.VERSION.SDK_INT >= 11) {
      setCustomSelectionActionModeCallback(new sog(this));
    }
    addTextChangedListener(new soh(this));
  }
  
  private boolean b()
  {
    int i = getSelectionStart();
    int j = getSelectionEnd();
    BlockableEditTextView.BlockAble[] arrayOfBlockAble = (BlockableEditTextView.BlockAble[])getEditableText().getSpans(i, j, BlockableEditTextView.BlockAble.class);
    if ((arrayOfBlockAble != null) && (arrayOfBlockAble.length > 0) && ((arrayOfBlockAble[0] instanceof BlockableEditTextView.BlockAble)))
    {
      i = getEditableText().getSpanEnd(arrayOfBlockAble[0]);
      j = getEditableText().getSpanStart(arrayOfBlockAble[0]);
      if ((j >= 0) && (i > j)) {
        return false;
      }
    }
    return true;
  }
  
  public boolean a()
  {
    if (getEditableText().length() == 0) {
      return false;
    }
    BlockableEditTextView.BlockAble[] arrayOfBlockAble = (BlockableEditTextView.BlockAble[])getEditableText().getSpans(0, getEditableText().length(), BlockableEditTextView.BlockAble.class);
    if ((arrayOfBlockAble != null) && (arrayOfBlockAble.length > 0))
    {
      int i = getEditableText().getSpanEnd(arrayOfBlockAble[0]);
      int j = getEditableText().getSpanStart(arrayOfBlockAble[0]);
      if ((j >= 0) && (i > j) && (i - j >= getEditableText().length())) {
        return false;
      }
    }
    return true;
  }
  
  protected void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    if ((b()) || (Build.VERSION.SDK_INT >= 11)) {
      super.onCreateContextMenu(paramContextMenu);
    }
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    BlockableEditTextView.BlockAble[] arrayOfBlockAble = (BlockableEditTextView.BlockAble[])getEditableText().getSpans(paramInt1, paramInt2, BlockableEditTextView.BlockAble.class);
    int i;
    int j;
    if ((arrayOfBlockAble != null) && (arrayOfBlockAble.length > 0))
    {
      i = getEditableText().getSpanEnd(arrayOfBlockAble[0]);
      j = getEditableText().getSpanStart(arrayOfBlockAble[0]);
      if ((i > j) && (j >= 0))
      {
        if ((paramInt1 != j) || (paramInt2 != j) || (!this.a)) {
          break label98;
        }
        setSelection(i);
      }
    }
    label98:
    do
    {
      do
      {
        return;
      } while ((this.f <= 0) || ((paramInt1 >= i) && (paramInt2 >= i)) || ((paramInt1 <= j) && (paramInt2 <= j)));
      if ((paramInt1 <= j) && (paramInt2 <= i))
      {
        setSelection(paramInt1, j);
        return;
      }
      if ((paramInt1 >= j) && (paramInt2 <= i))
      {
        setSelection(j);
        return;
      }
      if ((paramInt1 >= j) && (paramInt2 >= i))
      {
        setSelection(i, paramInt2);
        return;
      }
    } while ((paramInt1 > j) || (paramInt2 < i));
    setSelection(paramInt1, j);
  }
  
  public void setBlockFront(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void setEditStatus(int paramInt)
  {
    this.f = paramInt;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\tencent\mobileqq\freshnews\BlockableEditTextView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */