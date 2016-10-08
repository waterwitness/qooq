package com.tencent.ttpic;

import android.opengl.GLES20;
import android.util.SparseArray;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.Frame;
import com.tencent.filter.GLSLRender;
import com.tencent.filter.QImage;
import com.tencent.ttpic.filter.VideoFilterList;
import com.tencent.ttpic.model.VideoMaterial;
import com.tencent.ttpic.recorder.RetrieveDataListener;
import com.tencent.ttpic.util.AlgoUtils;
import com.tencent.ttpic.util.BenchUtil;
import com.tencent.ttpic.util.RetrieveDataUtil;
import com.tencent.ttpic.util.VideoMaterialUtil;
import com.tencent.ttpic.util.VideoUtil;
import com.tencent.ttpic.util.youtu.VideoPreviewFaceOutlineDetector;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class FilterProcessByte
  extends FilterProcessBase
{
  private static final String TAG = FilterProcessByte.class.getSimpleName();
  private static String yuv2rgb_shader = "mee388x1701998624x1769171299x1746955887x1885890409x1869375008x171668577x1918989856x1735289209x1667593760x1702109234x1920300152x1869562725x1852400754x996504673x1853169674x1919903337x1634934893x1701605485x541340274x1970302569x1634552180x1700029799x1920300152x168442725x1852793632x1830843507x540308577x1986948963x1769173605x1025535599x1952541984x774973492x538979376x741355056x538976288x808726065x757083186x808922672x774974513x757083184x875769392x757083188x825699888x538979380x842346032x774974521x538979376x926363185x538979378x741355056x757080096x943205936x741354550x808333344x774905900x807414832x992555054x1870012426x1830839401x678324577x2065697321x538976266x1702240288x2032153699x1025537653x2019914784x1701999988x1764246578x1953853550x1734438217x2019906661x1701999988x1702109228x1920300152x1869562725x1852400754x694514785x538970683x1981816864x540238693x543319922x2032672829x706770549x1852793632x1936876918x695103337x2054780974x538970683x1730158624x1917214572x1866688353x544370540x1702240317x1915237475x539779687x691023409x2099251771x";
  private QImage mPreviewImage = new QImage();
  byte[] rotate;
  byte[] scale;
  byte[] y;
  
  private void initYUVBuffer(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    if ((this.y == null) || (this.y.length < paramInt1 * paramInt2)) {
      this.y = new byte[paramInt1 * paramInt2];
    }
    paramInt1 = (int)(paramInt1 * paramInt2 * paramFloat1 * paramFloat2);
    if ((this.scale == null) || (this.scale.length < paramInt1))
    {
      this.scale = new byte[paramInt1];
      this.rotate = new byte[paramInt1];
    }
  }
  
  protected void initPreviewFilter()
  {
    this.mPreviewFilter = new BaseFilter(yuv2rgb_shader);
  }
  
  public void queueYUV(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    boolean bool = false;
    BenchUtil.benchStart("YUV420sp2YUV");
    this.mPreviewImage.YUV420sp2YUV(paramArrayOfByte, paramInt1, paramInt2);
    BenchUtil.benchEnd("YUV420sp2YUV");
    BenchUtil.benchStart("arraycopy");
    float f1 = (float)(VideoMaterialUtil.SCALE_FACE_DETECT * this.width / paramInt2);
    float f2 = (float)(VideoMaterialUtil.SCALE_FACE_DETECT * this.height / paramInt1);
    initYUVBuffer(paramInt1, paramInt2, f2, f1);
    System.arraycopy(paramArrayOfByte, 0, this.y, 0, paramInt1 * paramInt2);
    BenchUtil.benchEnd("arraycopy");
    BenchUtil.benchStart("processYUV");
    paramArrayOfByte = this.y;
    byte[] arrayOfByte = this.scale;
    if (this.flipX != this.flipY) {
      bool = true;
    }
    AlgoUtils.nativeScalePlane(paramArrayOfByte, arrayOfByte, paramInt1, paramInt2, f2, f1, true, bool);
    AlgoUtils.nativeRotatePlane(this.scale, this.rotate, (int)(paramInt1 * f2), (int)(paramInt2 * f1), (360 - this.rotation) % 360);
    BenchUtil.benchEnd("processYUV");
    BenchUtil.benchStart("doTrackProcesesByY");
    VideoPreviewFaceOutlineDetector.getInstance().init();
    VideoPreviewFaceOutlineDetector.getInstance().doTrackProcesesByY(this.rotate, (int)(paramInt2 * f1), (int)(paramInt1 * f2));
    if (VideoPreviewFaceOutlineDetector.getInstance().needDetectFace()) {
      VideoPreviewFaceOutlineDetector.getInstance().postJob(new Runnable()
      {
        public void run()
        {
          VideoPreviewFaceOutlineDetector.getInstance().doFaceDetect();
        }
      });
    }
    BenchUtil.benchEnd("doTrackProcesesByY");
  }
  
  public void showPreview(int paramInt1, int paramInt2)
  {
    BenchUtil.benchStart("nativeTextImage");
    GLSLRender.nativeTextImage(this.mPreviewImage, this.mPreviewTextureId[0]);
    BenchUtil.benchEnd("nativeTextImage");
    com.tencent.view.FilterDefault.currentShareIndex = -1;
    this.mPreviewFilter.nativeSetRotationAndFlip(this.rotation, this.flipX, this.flipY);
    this.mBlendFilter.nativeSetRotationAndFlip(-this.rotation, this.flipX, this.flipY);
    Object localObject1;
    int j;
    int i;
    Object localObject2;
    if (this.mVideoFilters != null)
    {
      localObject1 = this.mPreviewFilter.getmNextFilter();
      this.mPreviewFilter.removeTheFilter((BaseFilter)localObject1);
      this.mPreviewFilter.RenderProcess(this.mPreviewTextureId[0], this.width, this.height, this.mTempTextureId[0], this.mAspectRatio, this.mTempFrame);
      float f = VideoPreviewFaceOutlineDetector.getInstance().getPhotoAngle(this.mVideoFilters.getMaterial().isSupportLandscape());
      j = VideoPreviewFaceOutlineDetector.getInstance().getFaceCount();
      if (j <= 0)
      {
        this.mVideoFilters.updateAllFilters(null, VideoUtil.getFaceAngle(null), f);
        this.mVideoFilters.RenderProcess(this.mTempFrame.getFBO(), this.mTempFrame.getTextureId(), this.width, this.height);
      }
      i = 0;
      while (i < Math.min(j, this.mVideoFilters.getMaterial().getMaxFaceCount()))
      {
        localObject2 = VideoPreviewFaceOutlineDetector.getInstance().getAllPoints(i);
        this.mVideoFilters.updateAllFilters((List)localObject2, VideoUtil.getFaceAngle((List)localObject2), f);
        this.mVideoFilters.RenderProcess(this.mTempFrame.getFBO(), this.mTempFrame.getTextureId(), this.width, this.height);
        i += 1;
      }
      ((BaseFilter)localObject1).RenderProcess(this.mTempTextureId[0], this.width, this.height, -2, this.mAspectRatio, this.mPreviewFrame);
      if (this.onceTex != 0) {
        ((BaseFilter)localObject1).RenderProcess(this.onceTex, this.width, this.height, -2, this.mAspectRatio, this.mPreviewFrame);
      }
      this.mPreviewFilter.setNextFilter((BaseFilter)localObject1, null);
      if (this.onceTex == 0) {
        break label552;
      }
      this.mViewFilter.RenderProcess(this.onceTex, paramInt1, paramInt2, 0, this.mAspectRatio, this.mViewFrame);
      this.showOnceTexCount += 1;
      if (this.showOnceTexCount >= 1)
      {
        GLES20.glDeleteTextures(1, new int[] { this.onceTex }, 0);
        this.onceTex = 0;
      }
      label427:
      i = 0;
    }
    for (;;)
    {
      if (i >= this.mRetrieveDataListener.size()) {
        break label590;
      }
      j = this.mRetrieveDataListener.keyAt(i);
      localObject1 = RetrieveDataUtil.retrieveData(j, getSecondLastTextureId(this.mPreviewFrame), paramInt1, paramInt2);
      localObject2 = ((Set)this.mRetrieveDataListener.get(j)).iterator();
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          ((RetrieveDataListener)((Iterator)localObject2).next()).retrieveData(j, (byte[])localObject1);
          continue;
          this.mPreviewFilter.RenderProcess(this.mPreviewTextureId[0], this.width, this.height, -2, 0.0D, this.mPreviewFrame);
          break;
          label552:
          this.mViewFilter.RenderProcess(getSecondLastTextureId(this.mPreviewFrame), paramInt1, paramInt2, 0, this.mAspectRatio, this.mViewFrame);
          break label427;
        }
      }
      i += 1;
    }
    label590:
    if (this.cannotReuseFrameBuffer)
    {
      this.mPreviewFrame.clear();
      this.mFlipFrame.clear();
      this.mTempFrame.clear();
      this.mViewFrame.clear();
    }
  }
}


/* Location:              E:\apk\QQ_91\classes3-dex2jar.jar!\com\tencent\ttpic\FilterProcessByte.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */