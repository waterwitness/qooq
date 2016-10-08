import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.biz.common.util.Util;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.pgc.QQStoryContentActivity;
import com.tencent.biz.qqstory.pgc.model.Story;
import com.tencent.biz.qqstory.pgc.model.StoryPostDes;
import com.tencent.biz.qqstory.pgc.view.PostContentView;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.widget.ResponsiveScrollView;
import com.tencent.mobileqq.hotpatch.NotVerifyClass;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import java.net.URLDecoder;
import java.util.Arrays;
import java.util.List;

public class imo
  extends WebViewClient
{
  public imo(PostContentView paramPostContentView)
  {
    boolean bool = NotVerifyClass.DO_VERIFY_CLASS;
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    this.a.e.setVisibility(8);
    if (this.a.jdField_f_of_type_AndroidViewView.getVisibility() != 0)
    {
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView.setVisibility(0);
      if ((paramString != null) && (paramString.equals(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.postDes.url)))
      {
        StoryReportor.a("play_page_web", "suc", ((QQStoryContentActivity)this.a.getContext()).g, 0, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, StoryReportor.a(this.a.getContext()), "" });
        if ((this.a.g) && (PostContentView.a(this.a) == 1)) {
          this.a.jdField_a_of_type_ComTencentBizQqstoryBaseQQStoryHandler.a(this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUserType(), this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), 4);
        }
      }
    }
    this.a.jdField_f_of_type_Boolean = true;
    super.onPageFinished(paramWebView, paramString);
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.a.jdField_f_of_type_AndroidViewView.setVisibility(0);
    this.a.e.setVisibility(8);
    this.a.jdField_a_of_type_ComTencentBizQqstoryViewWidgetResponsiveScrollView.setVisibility(8);
    this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(new imp(this, paramString2));
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    StoryReportor.a("play_page_web", "fail", ((QQStoryContentActivity)this.a.getContext()).g, 0, new String[] { this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.getUnionId(), this.a.jdField_a_of_type_ComTencentBizQqstoryPgcModelStory.storyId, StoryReportor.a(this.a.getContext()), "" });
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    boolean bool = false;
    if (TextUtils.isEmpty(paramString)) {
      bool = true;
    }
    String[] arrayOfString;
    do
    {
      return bool;
      if ((TextUtils.isEmpty(paramString)) || ("about:blank;".equals(paramString)) || ("about:blank".equals(paramString))) {
        return true;
      }
      if (!paramString.startsWith("story://")) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d(PostContentView.b, 2, "shouldOverrideUrlLoading " + Util.b(paramString, new String[0]));
      }
      paramWebView = paramString;
      if (!TextUtils.isEmpty(paramString))
      {
        str = paramString;
        if (paramString.startsWith("story://")) {
          str = paramString.replace("story://", "");
        }
        paramWebView = str;
        if (QLog.isColorLevel())
        {
          QLog.d(PostContentView.b, 2, "shouldOverrideUrlLoading  temp url = " + str);
          paramWebView = str;
        }
      }
      paramString = paramWebView;
      if (paramWebView.endsWith("/")) {
        paramString = paramWebView.substring(0, paramWebView.length() - 1);
      }
      arrayOfString = paramString.split("/");
    } while (arrayOfString.length < 2);
    paramString = arrayOfString[0];
    String str = arrayOfString[1];
    paramWebView = null;
    if (arrayOfString.length > 2)
    {
      paramWebView = new String[arrayOfString.length - 2];
      int i = 2;
      while (i < arrayOfString.length)
      {
        paramWebView[(i - 2)] = URLDecoder.decode(arrayOfString[i]);
        i += 1;
      }
    }
    if (Arrays.asList(PostContentView.a(this.a)).indexOf(paramString) == -1)
    {
      if (QLog.isColorLevel()) {
        QLog.d(PostContentView.b, 2, "cannot response request for " + paramString);
      }
      return true;
    }
    PostContentView.a(this.a, paramString, str, paramWebView);
    return true;
    return super.shouldOverrideUrlLoading(paramWebView, paramString);
  }
}


/* Location:              E:\apk\QQ_91\classes6-dex2jar.jar!\imo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */