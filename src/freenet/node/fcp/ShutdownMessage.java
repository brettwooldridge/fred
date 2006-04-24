package freenet.node.fcp;

import freenet.node.Node;
import freenet.node.fcp.FCPMessage;
import freenet.support.SimpleFieldSet;

public class ShutdownMessage extends FCPMessage{
	public final static String name = "Shutdown";
	
	public ShutdownMessage() throws MessageInvalidException {
	}

	public SimpleFieldSet getFieldSet() {
		return new SimpleFieldSet(false);
	}

	public String getName() {
		return name;
	}

	public void run(FCPConnectionHandler handler, Node node) {
		FCPMessage msg = new ProtocolErrorMessage(ProtocolErrorMessage.SHUTTING_DOWN,true,"The node is shutting down","Node");
		handler.outputHandler.queue(msg);
		node.exit();
	}	
}