package com.facebook.react.views.textinput;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.views.text.CustomStyleSpan;
import com.facebook.react.views.text.ReactTagSpan;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextInlineImageSpan;
import java.util.ArrayList;
import java.util.Iterator;
import javax.annotation.Nullable;

public class ReactEditText
  extends EditText
{
  private boolean mContainsImages;
  private int mDefaultGravityHorizontal;
  private int mDefaultGravityVertical;
  private final InputMethodManager mInputMethodManager;
  private boolean mIsJSSettingFocus;
  private boolean mIsSettingTextFromJS;
  @Nullable
  private ArrayList<TextWatcher> mListeners;
  private int mNativeEventCount;
  private int mStagedInputType;
  @Nullable
  private TextWatcherDelegator mTextWatcherDelegator;
  
  public ReactEditText(Context paramContext)
  {
    super(paramContext);
    setFocusableInTouchMode(false);
    this.mInputMethodManager = ((InputMethodManager)Assertions.assertNotNull(getContext().getSystemService("input_method")));
    this.mDefaultGravityHorizontal = (getGravity() & 0x800007);
    this.mDefaultGravityVertical = (getGravity() & 0x70);
    this.mNativeEventCount = 0;
    this.mIsSettingTextFromJS = false;
    this.mIsJSSettingFocus = false;
    this.mListeners = null;
    this.mTextWatcherDelegator = null;
    this.mStagedInputType = getInputType();
  }
  
  private TextWatcherDelegator getTextWatcherDelegator()
  {
    if (this.mTextWatcherDelegator == null) {
      this.mTextWatcherDelegator = new TextWatcherDelegator(null);
    }
    return this.mTextWatcherDelegator;
  }
  
  private void hideSoftKeyboard()
  {
    this.mInputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
  }
  
  private void manageSpans(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object[] arrayOfObject = getText().getSpans(0, length(), Object.class);
    int i = 0;
    if (i < arrayOfObject.length)
    {
      if ((ForegroundColorSpan.class.isInstance(arrayOfObject[i])) || (BackgroundColorSpan.class.isInstance(arrayOfObject[i])) || (AbsoluteSizeSpan.class.isInstance(arrayOfObject[i])) || (CustomStyleSpan.class.isInstance(arrayOfObject[i])) || (ReactTagSpan.class.isInstance(arrayOfObject[i]))) {
        getText().removeSpan(arrayOfObject[i]);
      }
      if ((getText().getSpanFlags(arrayOfObject[i]) & 0x21) != 33) {}
      for (;;)
      {
        i += 1;
        break;
        Object localObject = arrayOfObject[i];
        int j = getText().getSpanStart(arrayOfObject[i]);
        int k = getText().getSpanEnd(arrayOfObject[i]);
        int m = getText().getSpanFlags(arrayOfObject[i]);
        getText().removeSpan(arrayOfObject[i]);
        if (sameTextForSpan(getText(), paramSpannableStringBuilder, j, k)) {
          paramSpannableStringBuilder.setSpan(localObject, j, k, m);
        }
      }
    }
  }
  
  private static boolean sameTextForSpan(Editable paramEditable, SpannableStringBuilder paramSpannableStringBuilder, int paramInt1, int paramInt2)
  {
    if ((paramInt1 > paramSpannableStringBuilder.length()) || (paramInt2 > paramSpannableStringBuilder.length())) {
      return false;
    }
    for (;;)
    {
      if (paramInt1 >= paramInt2) {
        break label45;
      }
      if (paramEditable.charAt(paramInt1) != paramSpannableStringBuilder.charAt(paramInt1)) {
        break;
      }
      paramInt1 += 1;
    }
    label45:
    return true;
  }
  
  private boolean showSoftKeyboard()
  {
    return this.mInputMethodManager.showSoftInput(this, 0);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    if (this.mListeners == null)
    {
      this.mListeners = new ArrayList();
      super.addTextChangedListener(getTextWatcherDelegator());
    }
    this.mListeners.add(paramTextWatcher);
  }
  
  public void clearFocus()
  {
    setFocusableInTouchMode(false);
    super.clearFocus();
    hideSoftKeyboard();
  }
  
  void clearFocusFromJS()
  {
    clearFocus();
  }
  
  void commitStagedInputType()
  {
    if (getInputType() != this.mStagedInputType) {
      setInputType(this.mStagedInputType);
    }
  }
  
  int getStagedInputType()
  {
    return this.mStagedInputType;
  }
  
  public int incrementAndGetEventCounter()
  {
    int i = this.mNativeEventCount + 1;
    this.mNativeEventCount = i;
    return i;
  }
  
  public void invalidateDrawable(Drawable paramDrawable)
  {
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i].getDrawable() == paramDrawable) {
          invalidate();
        }
        i += 1;
      }
    }
    super.invalidateDrawable(paramDrawable);
  }
  
  public boolean isLayoutRequested()
  {
    return false;
  }
  
  public void maybeSetText(ReactTextUpdate paramReactTextUpdate)
  {
    if (paramReactTextUpdate.getJsEventCounter() < this.mNativeEventCount) {
      return;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramReactTextUpdate.getText());
    manageSpans(localSpannableStringBuilder);
    this.mContainsImages = paramReactTextUpdate.containsImages();
    this.mIsSettingTextFromJS = true;
    getText().replace(0, length(), localSpannableStringBuilder);
    this.mIsSettingTextFromJS = false;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].onAttachedToWindow();
        i += 1;
      }
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].onDetachedFromWindow();
        i += 1;
      }
    }
  }
  
  public void onFinishTemporaryDetach()
  {
    super.onFinishTemporaryDetach();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].onFinishTemporaryDetach();
        i += 1;
      }
    }
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 66) && ((getInputType() & 0x20000) == 0))
    {
      hideSoftKeyboard();
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public void onStartTemporaryDetach()
  {
    super.onStartTemporaryDetach();
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        localObject[i].onStartTemporaryDetach();
        i += 1;
      }
    }
  }
  
  public void removeTextChangedListener(TextWatcher paramTextWatcher)
  {
    if (this.mListeners != null)
    {
      this.mListeners.remove(paramTextWatcher);
      if (this.mListeners.isEmpty())
      {
        this.mListeners = null;
        super.removeTextChangedListener(getTextWatcherDelegator());
      }
    }
  }
  
  public boolean requestFocus(int paramInt, Rect paramRect)
  {
    if (isFocused()) {
      return true;
    }
    if (!this.mIsJSSettingFocus) {
      return false;
    }
    setFocusableInTouchMode(true);
    boolean bool = super.requestFocus(paramInt, paramRect);
    showSoftKeyboard();
    return bool;
  }
  
  void requestFocusFromJS()
  {
    this.mIsJSSettingFocus = true;
    requestFocus();
    this.mIsJSSettingFocus = false;
  }
  
  void setGravityHorizontal(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = this.mDefaultGravityHorizontal;
    }
    setGravity(getGravity() & 0xFFFFFFF8 & 0xFF7FFFF8 | i);
  }
  
  void setGravityVertical(int paramInt)
  {
    int i = paramInt;
    if (paramInt == 0) {
      i = this.mDefaultGravityVertical;
    }
    setGravity(getGravity() & 0xFFFFFF8F | i);
  }
  
  public void setInputType(int paramInt)
  {
    super.setInputType(paramInt);
    this.mStagedInputType = paramInt;
  }
  
  void setStagedInputType(int paramInt)
  {
    this.mStagedInputType = paramInt;
  }
  
  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    if ((this.mContainsImages) && ((getText() instanceof Spanned)))
    {
      Object localObject = getText();
      localObject = (TextInlineImageSpan[])((Spanned)localObject).getSpans(0, ((Spanned)localObject).length(), TextInlineImageSpan.class);
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        if (localObject[i].getDrawable() == paramDrawable) {
          return true;
        }
        i += 1;
      }
    }
    return super.verifyDrawable(paramDrawable);
  }
  
  private class TextWatcherDelegator
    implements TextWatcher
  {
    private TextWatcherDelegator() {}
    
    public void afterTextChanged(Editable paramEditable)
    {
      if ((!ReactEditText.this.mIsSettingTextFromJS) && (ReactEditText.this.mListeners != null))
      {
        Iterator localIterator = ReactEditText.this.mListeners.iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).afterTextChanged(paramEditable);
        }
      }
    }
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((!ReactEditText.this.mIsSettingTextFromJS) && (ReactEditText.this.mListeners != null))
      {
        Iterator localIterator = ReactEditText.this.mListeners.iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
        }
      }
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((!ReactEditText.this.mIsSettingTextFromJS) && (ReactEditText.this.mListeners != null))
      {
        Iterator localIterator = ReactEditText.this.mListeners.iterator();
        while (localIterator.hasNext()) {
          ((TextWatcher)localIterator.next()).onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
        }
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\textinput\ReactEditText.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */