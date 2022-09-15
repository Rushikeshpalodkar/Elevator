
public class RequestQueue {

  private int size;

  private class RequestNode{
    Request request;
    RequestNode next;
  }

  private RequestNode frontNode;
  private RequestNode rearNode;

  RequestQueue() {
    frontNode = null;
    rearNode = null;
    size = 0;
  }

  public int Size() {
    return size;
  }

  public void enqueue(Request newRequest) {
    if (newRequest == null) {
      throw new IllegalArgumentException("Request cannot be null");
    }
    RequestNode newNode = new RequestNode();
    newNode.request = newRequest;
    newNode.next = null;

    if (size == 0) {
      frontNode = newNode;
      rearNode = frontNode;
    } else {
      rearNode.next = newNode;
      rearNode = newNode;
    }
    size++;
  }

  public Request dequeue() {
    if (size == 0) { // front == null
      throw new IllegalArgumentException("Queue is empty");
    }
    Request request = frontNode.request; //works because size is not 0
    frontNode = frontNode.next;
    if (frontNode == null) {
      rearNode = null;
    }
    size--;
    return request;
  }

  public boolean isEmpty() {
    return size == 0;
  }



}
