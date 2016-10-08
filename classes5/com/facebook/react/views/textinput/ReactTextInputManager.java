package com.facebook.react.views.textinput;

import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.Layout;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSApplicationCausedNativeException;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.common.MapBuilder.Builder;
import com.facebook.react.uimanager.BaseViewManager;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactProp;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.views.text.DefaultStyleValuesUtil;
import com.facebook.react.views.text.ReactTextUpdate;
import com.facebook.react.views.text.TextInlineImageSpan;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactTextInputManager
  extends BaseViewManager<ReactEditText, ReactTextInputShadowNode>
{
  private static final int BLUR_TEXT_INPUT = 2;
  private static final InputFilter[] EMPTY_FILTERS = new InputFilter[0];
  private static final int FOCUS_TEXT_INPUT = 1;
  private static final String KEYBOARD_TYPE_EMAIL_ADDRESS = "email-address";
  private static final String KEYBOARD_TYPE_NUMERIC = "numeric";
  static final String REACT_CLASS = "AndroidTextInput";
  
  public static Map<String, Object> getBubblingEventTypeConstants()
  {
    return MapBuilder.builder().put("topSubmitEditing", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onSubmitEditing", "captured", "onSubmitEditingCapture"))).put("topEndEditing", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onEndEditing", "captured", "onEndEditingCapture"))).put("topTextInput", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onTextInput", "captured", "onTextInputCapture"))).put("topFocus", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onFocus", "captured", "onFocusCapture"))).put("topBlur", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onBlur", "captured", "onBlurCapture"))).build();
  }
  
  @Nullable
  public static Map<String, Integer> getStaticCommandsMap()
  {
    return MapBuilder.of("focusTextInput", Integer.valueOf(1), "blurTextInput", Integer.valueOf(2));
  }
  
  public static Map<String, Object> getStaticExportedCustomBubblingEventTypeConstants()
  {
    return getBubblingEventTypeConstants();
  }
  
  @Nullable
  public static Map getStaticExportedViewConstants()
  {
    return MapBuilder.of("TextAlign", MapBuilder.of("start", Integer.valueOf(8388611), "center", Integer.valueOf(1), "end", Integer.valueOf(8388613)), "TextAlignVertical", MapBuilder.of("top", Integer.valueOf(48), "center", Integer.valueOf(16), "bottom", Integer.valueOf(80)));
  }
  
  public static String getStaticName()
  {
    return "AndroidTextInput";
  }
  
  public static Class<ReactTextInputShadowNode> getStaticShadowNodeClass()
  {
    return ReactTextInputShadowNode.class;
  }
  
  public static Map<String, Object> sgetExportedCustomBubblingEventTypeConstants()
  {
    return getBubblingEventTypeConstants();
  }
  
  private static void updateStagedInputTypeFlag(ReactEditText paramReactEditText, int paramInt1, int paramInt2)
  {
    paramReactEditText.setStagedInputType(paramReactEditText.getStagedInputType() & (paramInt1 ^ 0xFFFFFFFF) | paramInt2);
  }
  
  protected void addEventEmitters(final ThemedReactContext paramThemedReactContext, final ReactEditText paramReactEditText)
  {
    paramReactEditText.addTextChangedListener(new ReactTextInputTextWatcher(paramThemedReactContext, paramReactEditText));
    paramReactEditText.setOnFocusChangeListener(new View.OnFocusChangeListener()
    {
      public void onFocusChange(View paramAnonymousView, boolean paramAnonymousBoolean)
      {
        paramAnonymousView = ((UIManagerModule)paramThemedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
        if (paramAnonymousBoolean)
        {
          paramAnonymousView.dispatchEvent(new ReactTextInputFocusEvent(paramReactEditText.getId(), SystemClock.uptimeMillis()));
          return;
        }
        paramAnonymousView.dispatchEvent(new ReactTextInputBlurEvent(paramReactEditText.getId(), SystemClock.uptimeMillis()));
        paramAnonymousView.dispatchEvent(new ReactTextInputEndEditingEvent(paramReactEditText.getId(), SystemClock.uptimeMillis(), paramReactEditText.getText().toString()));
      }
    });
    paramReactEditText.setOnEditorActionListener(new TextView.OnEditorActionListener()
    {
      public boolean onEditorAction(TextView paramAnonymousTextView, int paramAnonymousInt, KeyEvent paramAnonymousKeyEvent)
      {
        if (((paramAnonymousInt & 0xFF) > 0) || (paramAnonymousInt == 0)) {
          ((UIManagerModule)paramThemedReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(new ReactTextInputSubmitEditingEvent(paramReactEditText.getId(), SystemClock.uptimeMillis(), paramReactEditText.getText().toString()));
        }
        return false;
      }
    });
  }
  
  public ReactTextInputShadowNode createShadowNodeInstance()
  {
    return new ReactTextInputShadowNode();
  }
  
  public ReactEditText createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    paramThemedReactContext = new ReactEditText(paramThemedReactContext);
    paramThemedReactContext.setInputType(0xFFFDFFFF & paramThemedReactContext.getInputType());
    paramThemedReactContext.setImeOptions(6);
    paramThemedReactContext.setTextSize(0, (int)Math.ceil(PixelUtil.toPixelFromSP(14.0F)));
    return paramThemedReactContext;
  }
  
  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return getStaticCommandsMap();
  }
  
  @Nullable
  public Map<String, Object> getExportedCustomBubblingEventTypeConstants()
  {
    return getStaticExportedCustomBubblingEventTypeConstants();
  }
  
  @Nullable
  public Map getExportedViewConstants()
  {
    return getStaticExportedViewConstants();
  }
  
  public String getName()
  {
    return getStaticName();
  }
  
  public Class<ReactTextInputShadowNode> getShadowNodeClass()
  {
    return getStaticShadowNodeClass();
  }
  
  protected void onAfterUpdateTransaction(ReactEditText paramReactEditText)
  {
    super.onAfterUpdateTransaction(paramReactEditText);
    paramReactEditText.commitStagedInputType();
  }
  
  public void receiveCommand(ReactEditText paramReactEditText, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      paramReactEditText.requestFocusFromJS();
      return;
    }
    paramReactEditText.clearFocusFromJS();
  }
  
  @ReactProp(defaultInt=1, name="autoCapitalize")
  public void setAutoCapitalize(ReactEditText paramReactEditText, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new JSApplicationCausedNativeException("Invalid autoCapitalize value: " + paramInt);
    }
    updateStagedInputTypeFlag(paramReactEditText, 28672, paramInt);
  }
  
  @ReactProp(name="autoCorrect")
  public void setAutoCorrect(ReactEditText paramReactEditText, @Nullable Boolean paramBoolean)
  {
    int i;
    if (paramBoolean != null) {
      if (paramBoolean.booleanValue()) {
        i = 32768;
      }
    }
    for (;;)
    {
      updateStagedInputTypeFlag(paramReactEditText, 557056, i);
      return;
      i = 524288;
      continue;
      i = 0;
    }
  }
  
  @ReactProp(defaultBoolean=true, name="editable")
  public void setEditable(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    paramReactEditText.setEnabled(paramBoolean);
  }
  
  @ReactProp(defaultFloat=14.0F, name="fontSize")
  public void setFontSize(ReactEditText paramReactEditText, float paramFloat)
  {
    paramReactEditText.setTextSize(0, (int)Math.ceil(PixelUtil.toPixelFromSP(paramFloat)));
  }
  
  @ReactProp(name="keyboardType")
  public void setKeyboardType(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    int i = 0;
    if ("numeric".equalsIgnoreCase(paramString)) {
      i = 2;
    }
    for (;;)
    {
      updateStagedInputTypeFlag(paramReactEditText, 34, i);
      return;
      if ("email-address".equalsIgnoreCase(paramString)) {
        i = 32;
      }
    }
  }
  
  @ReactProp(name="maxLength")
  public void setMaxLength(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactEditText.setFilters(EMPTY_FILTERS);
      return;
    }
    paramReactEditText.setFilters(new InputFilter[] { new InputFilter.LengthFilter(paramInteger.intValue()) });
  }
  
  @ReactProp(defaultBoolean=false, name="multiline")
  public void setMultiline(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    int j = 131072;
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (!paramBoolean) {
        break label30;
      }
    }
    for (;;)
    {
      updateStagedInputTypeFlag(paramReactEditText, i, j);
      return;
      i = 131072;
      break;
      label30:
      j = 0;
    }
  }
  
  @ReactProp(defaultInt=1, name="numberOfLines")
  public void setNumLines(ReactEditText paramReactEditText, int paramInt)
  {
    paramReactEditText.setLines(paramInt);
  }
  
  @ReactProp(defaultBoolean=false, name="password")
  public void setPassword(ReactEditText paramReactEditText, boolean paramBoolean)
  {
    int j = 128;
    int i;
    if (paramBoolean)
    {
      i = 0;
      if (!paramBoolean) {
        break label30;
      }
    }
    for (;;)
    {
      updateStagedInputTypeFlag(paramReactEditText, i, j);
      return;
      i = 128;
      break;
      label30:
      j = 0;
    }
  }
  
  @ReactProp(name="placeholder")
  public void setPlaceholder(ReactEditText paramReactEditText, @Nullable String paramString)
  {
    paramReactEditText.setHint(paramString);
  }
  
  @ReactProp(customType="Color", name="placeholderTextColor")
  public void setPlaceholderTextColor(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactEditText.setHintTextColor(DefaultStyleValuesUtil.getDefaultTextColorHint(paramReactEditText.getContext()));
      return;
    }
    paramReactEditText.setHintTextColor(paramInteger.intValue());
  }
  
  @ReactProp(name="textAlign")
  public void setTextAlign(ReactEditText paramReactEditText, int paramInt)
  {
    paramReactEditText.setGravityHorizontal(paramInt);
  }
  
  @ReactProp(name="textAlignVertical")
  public void setTextAlignVertical(ReactEditText paramReactEditText, int paramInt)
  {
    paramReactEditText.setGravityVertical(paramInt);
  }
  
  @ReactProp(customType="Color", name="underlineColorAndroid")
  public void setUnderlineColor(ReactEditText paramReactEditText, @Nullable Integer paramInteger)
  {
    if (paramInteger == null)
    {
      paramReactEditText.getBackground().clearColorFilter();
      return;
    }
    paramReactEditText.getBackground().setColorFilter(paramInteger.intValue(), PorterDuff.Mode.SRC_IN);
  }
  
  public void updateExtraData(ReactEditText paramReactEditText, Object paramObject)
  {
    if ((paramObject instanceof float[]))
    {
      paramObject = (float[])paramObject;
      paramReactEditText.setPadding((int)Math.ceil(paramObject[0]), (int)Math.ceil(paramObject[1]), (int)Math.ceil(paramObject[2]), (int)Math.ceil(paramObject[3]));
    }
    while (!(paramObject instanceof ReactTextUpdate)) {
      return;
    }
    paramObject = (ReactTextUpdate)paramObject;
    if (((ReactTextUpdate)paramObject).containsImages()) {
      TextInlineImageSpan.possiblyUpdateInlineImageSpans(((ReactTextUpdate)paramObject).getText(), paramReactEditText);
    }
    paramReactEditText.maybeSetText((ReactTextUpdate)paramObject);
  }
  
  private class ReactTextInputTextWatcher
    implements TextWatcher
  {
    private ReactEditText mEditText;
    private EventDispatcher mEventDispatcher;
    private String mPreviousText;
    
    public ReactTextInputTextWatcher(ReactContext paramReactContext, ReactEditText paramReactEditText)
    {
      this.mEventDispatcher = ((UIManagerModule)paramReactContext.getNativeModule(UIManagerModule.class)).getEventDispatcher();
      this.mEditText = paramReactEditText;
      this.mPreviousText = null;
    }
    
    public void afterTextChanged(Editable paramEditable) {}
    
    public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      this.mPreviousText = paramCharSequence.toString();
    }
    
    public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      if ((paramInt3 == 0) && (paramInt2 == 0)) {}
      String str1;
      String str2;
      do
      {
        return;
        Assertions.assertNotNull(this.mPreviousText);
        str1 = paramCharSequence.toString().substring(paramInt1, paramInt1 + paramInt3);
        str2 = this.mPreviousText.substring(paramInt1, paramInt1 + paramInt2);
      } while ((paramInt3 == paramInt2) && (str1.equals(str2)));
      int j = this.mEditText.getWidth();
      int i = this.mEditText.getHeight();
      if (this.mEditText.getLayout() != null)
      {
        j = this.mEditText.getCompoundPaddingLeft() + this.mEditText.getLayout().getWidth() + this.mEditText.getCompoundPaddingRight();
        i = this.mEditText.getCompoundPaddingTop() + this.mEditText.getLayout().getHeight() + this.mEditText.getCompoundPaddingTop();
      }
      this.mEventDispatcher.dispatchEvent(new ReactTextChangedEvent(this.mEditText.getId(), SystemClock.uptimeMillis(), paramCharSequence.toString(), (int)PixelUtil.toDIPFromPixel(j), (int)PixelUtil.toDIPFromPixel(i), this.mEditText.incrementAndGetEventCounter()));
      paramCharSequence = this.mEventDispatcher;
      i = this.mEditText.getId();
      long l = SystemClock.uptimeMillis();
      if (paramInt3 > 0) {}
      for (paramInt2 = paramInt1 + paramInt3 - 1;; paramInt2 = paramInt1 + paramInt2)
      {
        paramCharSequence.dispatchEvent(new ReactTextInputEvent(i, l, str1, str2, paramInt1, paramInt2));
        return;
      }
    }
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\react\views\textinput\ReactTextInputManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */