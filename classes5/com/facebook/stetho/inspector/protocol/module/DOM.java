package com.facebook.stetho.inspector.protocol.module;

import android.graphics.Color;
import com.facebook.stetho.common.Accumulator;
import com.facebook.stetho.common.ArrayListAccumulator;
import com.facebook.stetho.common.LogUtil;
import com.facebook.stetho.common.UncheckedCallable;
import com.facebook.stetho.common.Util;
import com.facebook.stetho.inspector.elements.Document;
import com.facebook.stetho.inspector.elements.Document.AttributeListAccumulator;
import com.facebook.stetho.inspector.elements.Document.UpdateListener;
import com.facebook.stetho.inspector.elements.DocumentView;
import com.facebook.stetho.inspector.elements.ElementInfo;
import com.facebook.stetho.inspector.elements.NodeDescriptor;
import com.facebook.stetho.inspector.elements.NodeType;
import com.facebook.stetho.inspector.helper.ChromePeerManager;
import com.facebook.stetho.inspector.helper.PeersRegisteredListener;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcException;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcPeer;
import com.facebook.stetho.inspector.jsonrpc.JsonRpcResult;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError;
import com.facebook.stetho.inspector.jsonrpc.protocol.JsonRpcError.ErrorCode;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsDomain;
import com.facebook.stetho.inspector.protocol.ChromeDevtoolsMethod;
import com.facebook.stetho.json.ObjectMapper;
import com.facebook.stetho.json.annotation.JsonProperty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class DOM
  implements ChromeDevtoolsDomain
{
  private ChildNodeInsertedEvent mCachedChildNodeInsertedEvent;
  private ChildNodeRemovedEvent mCachedChildNodeRemovedEvent;
  private final Document mDocument;
  private final DocumentUpdateListener mListener;
  private final ObjectMapper mObjectMapper = new ObjectMapper();
  private final ChromePeerManager mPeerManager;
  private final AtomicInteger mResultCounter;
  private final Map<String, List<Integer>> mSearchResults;
  
  public DOM(Document paramDocument)
  {
    this.mDocument = ((Document)Util.throwIfNull(paramDocument));
    this.mSearchResults = Collections.synchronizedMap(new HashMap());
    this.mResultCounter = new AtomicInteger(0);
    this.mPeerManager = new ChromePeerManager();
    this.mPeerManager.setListener(new PeerManagerListener(null));
    this.mListener = new DocumentUpdateListener(null);
  }
  
  private ChildNodeInsertedEvent acquireChildNodeInsertedEvent()
  {
    ChildNodeInsertedEvent localChildNodeInsertedEvent2 = this.mCachedChildNodeInsertedEvent;
    ChildNodeInsertedEvent localChildNodeInsertedEvent1 = localChildNodeInsertedEvent2;
    if (localChildNodeInsertedEvent2 == null) {
      localChildNodeInsertedEvent1 = new ChildNodeInsertedEvent(null);
    }
    this.mCachedChildNodeInsertedEvent = null;
    return localChildNodeInsertedEvent1;
  }
  
  private ChildNodeRemovedEvent acquireChildNodeRemovedEvent()
  {
    ChildNodeRemovedEvent localChildNodeRemovedEvent2 = this.mCachedChildNodeRemovedEvent;
    ChildNodeRemovedEvent localChildNodeRemovedEvent1 = localChildNodeRemovedEvent2;
    if (localChildNodeRemovedEvent2 == null) {
      localChildNodeRemovedEvent1 = new ChildNodeRemovedEvent(null);
    }
    this.mCachedChildNodeRemovedEvent = null;
    return localChildNodeRemovedEvent1;
  }
  
  private Node createNodeForElement(Object paramObject, DocumentView paramDocumentView)
  {
    Object localObject = this.mDocument.getNodeDescriptor(paramObject);
    Node localNode = new Node(null);
    localNode.nodeId = this.mDocument.getNodeIdForElement(paramObject).intValue();
    localNode.nodeType = ((NodeDescriptor)localObject).getNodeType(paramObject);
    localNode.nodeName = ((NodeDescriptor)localObject).getNodeName(paramObject);
    localNode.localName = ((NodeDescriptor)localObject).getLocalName(paramObject);
    localNode.nodeValue = ((NodeDescriptor)localObject).getNodeValue(paramObject);
    Document.AttributeListAccumulator localAttributeListAccumulator = new Document.AttributeListAccumulator();
    ((NodeDescriptor)localObject).getAttributes(paramObject, localAttributeListAccumulator);
    localNode.attributes = localAttributeListAccumulator;
    localObject = paramDocumentView.getElementInfo(paramObject);
    int i;
    int j;
    if (((ElementInfo)localObject).children.size() == 0)
    {
      paramObject = Collections.emptyList();
      i = 0;
      j = ((ElementInfo)localObject).children.size();
    }
    for (;;)
    {
      if (i >= j)
      {
        localNode.children = ((List)paramObject);
        localNode.childNodeCount = Integer.valueOf(((List)paramObject).size());
        return localNode;
        paramObject = new ArrayList(((ElementInfo)localObject).children.size());
        break;
      }
      ((List)paramObject).add(createNodeForElement(((ElementInfo)localObject).children.get(i), paramDocumentView));
      i += 1;
    }
  }
  
  private void releaseChildNodeInsertedEvent(ChildNodeInsertedEvent paramChildNodeInsertedEvent)
  {
    paramChildNodeInsertedEvent.parentNodeId = -1;
    paramChildNodeInsertedEvent.previousNodeId = -1;
    paramChildNodeInsertedEvent.node = null;
    if (this.mCachedChildNodeInsertedEvent == null) {
      this.mCachedChildNodeInsertedEvent = paramChildNodeInsertedEvent;
    }
  }
  
  private void releaseChildNodeRemovedEvent(ChildNodeRemovedEvent paramChildNodeRemovedEvent)
  {
    paramChildNodeRemovedEvent.parentNodeId = -1;
    paramChildNodeRemovedEvent.nodeId = -1;
    if (this.mCachedChildNodeRemovedEvent == null) {
      this.mCachedChildNodeRemovedEvent = paramChildNodeRemovedEvent;
    }
  }
  
  @ChromeDevtoolsMethod
  public void disable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    this.mPeerManager.removePeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public void discardSearchResults(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    paramJsonRpcPeer = (DiscardSearchResultsRequest)this.mObjectMapper.convertValue(paramJSONObject, DiscardSearchResultsRequest.class);
    if (paramJsonRpcPeer.searchId != null) {
      this.mSearchResults.remove(paramJsonRpcPeer.searchId);
    }
  }
  
  @ChromeDevtoolsMethod
  public void enable(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    this.mPeerManager.addPeer(paramJsonRpcPeer);
  }
  
  @ChromeDevtoolsMethod
  public JsonRpcResult getDocument(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    paramJsonRpcPeer = new GetDocumentResponse(null);
    paramJsonRpcPeer.root = ((Node)this.mDocument.postAndWait(new UncheckedCallable()
    {
      public DOM.Node call()
      {
        Object localObject = DOM.this.mDocument.getRootElement();
        return DOM.this.createNodeForElement(localObject, DOM.this.mDocument.getDocumentView());
      }
    }));
    return paramJsonRpcPeer;
  }
  
  @ChromeDevtoolsMethod
  public GetSearchResultsResponse getSearchResults(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    paramJsonRpcPeer = (GetSearchResultsRequest)this.mObjectMapper.convertValue(paramJSONObject, GetSearchResultsRequest.class);
    if (paramJsonRpcPeer.searchId == null)
    {
      LogUtil.w("searchId may not be null");
      return null;
    }
    paramJSONObject = (List)this.mSearchResults.get(paramJsonRpcPeer.searchId);
    if (paramJSONObject == null)
    {
      LogUtil.w("\"" + paramJsonRpcPeer.searchId + "\" is not a valid reference to a search result");
      return null;
    }
    paramJsonRpcPeer = paramJSONObject.subList(paramJsonRpcPeer.fromIndex, paramJsonRpcPeer.toIndex);
    paramJSONObject = new GetSearchResultsResponse(null);
    paramJSONObject.nodeIds = paramJsonRpcPeer;
    return paramJSONObject;
  }
  
  @ChromeDevtoolsMethod
  public void hideHighlight(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    this.mDocument.postAndWait(new Runnable()
    {
      public void run()
      {
        DOM.this.mDocument.hideHighlight();
      }
    });
  }
  
  @ChromeDevtoolsMethod
  public void highlightNode(final JsonRpcPeer paramJsonRpcPeer, final JSONObject paramJSONObject)
  {
    paramJsonRpcPeer = (HighlightNodeRequest)this.mObjectMapper.convertValue(paramJSONObject, HighlightNodeRequest.class);
    if (paramJsonRpcPeer.nodeId == null)
    {
      LogUtil.w("DOM.highlightNode was not given a nodeId; JS objectId is not supported");
      return;
    }
    paramJSONObject = paramJsonRpcPeer.highlightConfig.contentColor;
    if (paramJSONObject == null)
    {
      LogUtil.w("DOM.highlightNode was not given a color to highlight with");
      return;
    }
    this.mDocument.postAndWait(new Runnable()
    {
      public void run()
      {
        Object localObject = DOM.this.mDocument.getElementForNodeId(paramJsonRpcPeer.nodeId.intValue());
        if (localObject != null) {
          DOM.this.mDocument.highlightElement(localObject, paramJSONObject.getColor());
        }
      }
    });
  }
  
  @ChromeDevtoolsMethod
  public PerformSearchResponse performSearch(final JsonRpcPeer paramJsonRpcPeer, final JSONObject paramJSONObject)
  {
    paramJSONObject = (PerformSearchRequest)this.mObjectMapper.convertValue(paramJSONObject, PerformSearchRequest.class);
    paramJsonRpcPeer = new ArrayListAccumulator();
    this.mDocument.postAndWait(new Runnable()
    {
      public void run()
      {
        DOM.this.mDocument.findMatchingElements(paramJSONObject.query, paramJsonRpcPeer);
      }
    });
    paramJSONObject = String.valueOf(this.mResultCounter.getAndIncrement());
    this.mSearchResults.put(paramJSONObject, paramJsonRpcPeer);
    PerformSearchResponse localPerformSearchResponse = new PerformSearchResponse(null);
    localPerformSearchResponse.searchId = paramJSONObject;
    localPerformSearchResponse.resultCount = paramJsonRpcPeer.size();
    return localPerformSearchResponse;
  }
  
  @ChromeDevtoolsMethod
  public ResolveNodeResponse resolveNode(JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
    throws JsonRpcException
  {
    final ResolveNodeRequest localResolveNodeRequest = (ResolveNodeRequest)this.mObjectMapper.convertValue(paramJSONObject, ResolveNodeRequest.class);
    paramJSONObject = this.mDocument.postAndWait(new UncheckedCallable()
    {
      public Object call()
      {
        return DOM.this.mDocument.getElementForNodeId(localResolveNodeRequest.nodeId);
      }
    });
    if (paramJSONObject == null) {
      throw new JsonRpcException(new JsonRpcError(JsonRpcError.ErrorCode.INVALID_PARAMS, "No known nodeId=" + localResolveNodeRequest.nodeId, null));
    }
    int i = Runtime.mapObject(paramJsonRpcPeer, paramJSONObject);
    paramJsonRpcPeer = new Runtime.RemoteObject();
    paramJsonRpcPeer.type = Runtime.ObjectType.OBJECT;
    paramJsonRpcPeer.subtype = Runtime.ObjectSubType.NODE;
    paramJsonRpcPeer.className = paramJSONObject.getClass().getName();
    paramJsonRpcPeer.value = null;
    paramJsonRpcPeer.description = null;
    paramJsonRpcPeer.objectId = String.valueOf(i);
    paramJSONObject = new ResolveNodeResponse(null);
    paramJSONObject.object = paramJsonRpcPeer;
    return paramJSONObject;
  }
  
  @ChromeDevtoolsMethod
  public void setAttributesAsText(final JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    paramJsonRpcPeer = (SetAttributesAsTextRequest)this.mObjectMapper.convertValue(paramJSONObject, SetAttributesAsTextRequest.class);
    this.mDocument.postAndWait(new Runnable()
    {
      public void run()
      {
        Object localObject = DOM.this.mDocument.getElementForNodeId(paramJsonRpcPeer.nodeId);
        if (localObject != null) {
          DOM.this.mDocument.setAttributesAsText(localObject, paramJsonRpcPeer.text);
        }
      }
    });
  }
  
  @ChromeDevtoolsMethod
  public void setInspectModeEnabled(final JsonRpcPeer paramJsonRpcPeer, JSONObject paramJSONObject)
  {
    paramJsonRpcPeer = (SetInspectModeEnabledRequest)this.mObjectMapper.convertValue(paramJSONObject, SetInspectModeEnabledRequest.class);
    this.mDocument.postAndWait(new Runnable()
    {
      public void run()
      {
        DOM.this.mDocument.setInspectModeEnabled(paramJsonRpcPeer.enabled);
      }
    });
  }
  
  private static class AttributeModifiedEvent
  {
    @JsonProperty(required=true)
    public String name;
    @JsonProperty(required=true)
    public int nodeId;
    @JsonProperty(required=true)
    public String value;
  }
  
  private static class AttributeRemovedEvent
  {
    @JsonProperty(required=true)
    public String name;
    @JsonProperty(required=true)
    public int nodeId;
  }
  
  private static class ChildNodeInsertedEvent
  {
    @JsonProperty(required=true)
    public DOM.Node node;
    @JsonProperty(required=true)
    public int parentNodeId;
    @JsonProperty(required=true)
    public int previousNodeId;
  }
  
  private static class ChildNodeRemovedEvent
  {
    @JsonProperty(required=true)
    public int nodeId;
    @JsonProperty(required=true)
    public int parentNodeId;
  }
  
  private static class DiscardSearchResultsRequest
  {
    @JsonProperty(required=true)
    public String searchId;
  }
  
  private final class DocumentUpdateListener
    implements Document.UpdateListener
  {
    private DocumentUpdateListener() {}
    
    public void onAttributeModified(Object paramObject, String paramString1, String paramString2)
    {
      DOM.AttributeModifiedEvent localAttributeModifiedEvent = new DOM.AttributeModifiedEvent(null);
      localAttributeModifiedEvent.nodeId = DOM.this.mDocument.getNodeIdForElement(paramObject).intValue();
      localAttributeModifiedEvent.name = paramString1;
      localAttributeModifiedEvent.value = paramString2;
      DOM.this.mPeerManager.sendNotificationToPeers("DOM.onAttributeModified", localAttributeModifiedEvent);
    }
    
    public void onAttributeRemoved(Object paramObject, String paramString)
    {
      DOM.AttributeRemovedEvent localAttributeRemovedEvent = new DOM.AttributeRemovedEvent(null);
      localAttributeRemovedEvent.nodeId = DOM.this.mDocument.getNodeIdForElement(paramObject).intValue();
      localAttributeRemovedEvent.name = paramString;
      DOM.this.mPeerManager.sendNotificationToPeers("DOM.attributeRemoved", localAttributeRemovedEvent);
    }
    
    public void onChildNodeInserted(DocumentView paramDocumentView, Object paramObject, int paramInt1, int paramInt2, Accumulator<Object> paramAccumulator)
    {
      DOM.ChildNodeInsertedEvent localChildNodeInsertedEvent = DOM.this.acquireChildNodeInsertedEvent();
      localChildNodeInsertedEvent.parentNodeId = paramInt1;
      localChildNodeInsertedEvent.previousNodeId = paramInt2;
      localChildNodeInsertedEvent.node = DOM.this.createNodeForElement(paramObject, paramDocumentView);
      paramAccumulator.store(paramObject);
      DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeInserted", localChildNodeInsertedEvent);
      DOM.this.releaseChildNodeInsertedEvent(localChildNodeInsertedEvent);
    }
    
    public void onChildNodeRemoved(int paramInt1, int paramInt2)
    {
      DOM.ChildNodeRemovedEvent localChildNodeRemovedEvent = DOM.this.acquireChildNodeRemovedEvent();
      localChildNodeRemovedEvent.parentNodeId = paramInt1;
      localChildNodeRemovedEvent.nodeId = paramInt2;
      DOM.this.mPeerManager.sendNotificationToPeers("DOM.childNodeRemoved", localChildNodeRemovedEvent);
      DOM.this.releaseChildNodeRemovedEvent(localChildNodeRemovedEvent);
    }
    
    public void onInspectRequested(Object paramObject)
    {
      Integer localInteger = DOM.this.mDocument.getNodeIdForElement(paramObject);
      if (localInteger == null)
      {
        LogUtil.d("DocumentProvider.Listener.onInspectRequested() called for a non-mapped node: element=%s", new Object[] { paramObject });
        return;
      }
      paramObject = new DOM.InspectNodeRequestedEvent(null);
      ((DOM.InspectNodeRequestedEvent)paramObject).nodeId = localInteger.intValue();
      DOM.this.mPeerManager.sendNotificationToPeers("DOM.inspectNodeRequested", paramObject);
    }
  }
  
  private static class GetDocumentResponse
    implements JsonRpcResult
  {
    @JsonProperty(required=true)
    public DOM.Node root;
  }
  
  private static class GetSearchResultsRequest
  {
    @JsonProperty(required=true)
    public int fromIndex;
    @JsonProperty(required=true)
    public String searchId;
    @JsonProperty(required=true)
    public int toIndex;
  }
  
  private static class GetSearchResultsResponse
    implements JsonRpcResult
  {
    @JsonProperty(required=true)
    public List<Integer> nodeIds;
  }
  
  private static class HighlightConfig
  {
    @JsonProperty
    public DOM.RGBAColor contentColor;
  }
  
  private static class HighlightNodeRequest
  {
    @JsonProperty(required=true)
    public DOM.HighlightConfig highlightConfig;
    @JsonProperty
    public Integer nodeId;
    @JsonProperty
    public String objectId;
  }
  
  private static class InspectNodeRequestedEvent
  {
    @JsonProperty
    public int nodeId;
  }
  
  private static class Node
    implements JsonRpcResult
  {
    @JsonProperty
    public List<String> attributes;
    @JsonProperty
    public Integer childNodeCount;
    @JsonProperty
    public List<Node> children;
    @JsonProperty(required=true)
    public String localName;
    @JsonProperty(required=true)
    public int nodeId;
    @JsonProperty(required=true)
    public String nodeName;
    @JsonProperty(required=true)
    public NodeType nodeType;
    @JsonProperty(required=true)
    public String nodeValue;
  }
  
  private final class PeerManagerListener
    extends PeersRegisteredListener
  {
    private PeerManagerListener() {}
    
    protected void onFirstPeerRegistered()
    {
      try
      {
        DOM.this.mDocument.addRef();
        DOM.this.mDocument.addUpdateListener(DOM.this.mListener);
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
    
    protected void onLastPeerUnregistered()
    {
      try
      {
        DOM.this.mSearchResults.clear();
        DOM.this.mDocument.removeUpdateListener(DOM.this.mListener);
        DOM.this.mDocument.release();
        return;
      }
      finally
      {
        localObject = finally;
        throw ((Throwable)localObject);
      }
    }
  }
  
  private static class PerformSearchRequest
  {
    @JsonProperty
    public Boolean includeUserAgentShadowDOM;
    @JsonProperty(required=true)
    public String query;
  }
  
  private static class PerformSearchResponse
    implements JsonRpcResult
  {
    @JsonProperty(required=true)
    public int resultCount;
    @JsonProperty(required=true)
    public String searchId;
  }
  
  private static class RGBAColor
  {
    @JsonProperty
    public Double a;
    @JsonProperty(required=true)
    public int b;
    @JsonProperty(required=true)
    public int g;
    @JsonProperty(required=true)
    public int r;
    
    public int getColor()
    {
      int i;
      if (this.a == null)
      {
        i = -1;
        return Color.argb(i, this.r, this.g, this.b);
      }
      long l = Math.round(this.a.doubleValue() * 255.0D);
      if (l < 0L) {
        i = 0;
      }
      for (;;)
      {
        break;
        if (l >= 255L) {
          i = -1;
        } else {
          i = (byte)(int)l;
        }
      }
    }
  }
  
  private static class ResolveNodeRequest
  {
    @JsonProperty(required=true)
    public int nodeId;
    @JsonProperty
    public String objectGroup;
  }
  
  private static class ResolveNodeResponse
    implements JsonRpcResult
  {
    @JsonProperty(required=true)
    public Runtime.RemoteObject object;
  }
  
  private static class SetAttributesAsTextRequest
  {
    @JsonProperty(required=true)
    public int nodeId;
    @JsonProperty(required=true)
    public String text;
  }
  
  private static class SetInspectModeEnabledRequest
  {
    @JsonProperty(required=true)
    public boolean enabled;
    @JsonProperty
    public DOM.HighlightConfig highlightConfig;
    @JsonProperty
    public Boolean inspectShadowDOM;
  }
}


/* Location:              E:\apk\QQ_91\classes5-dex2jar.jar!\com\facebook\stetho\inspector\protocol\module\DOM.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */