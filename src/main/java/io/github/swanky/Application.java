package io.github.swanky;

public class Application {

	public static void main(String[] args) {
		String deviceId = "RS06000D6F0001734C8A";
		String email = "swanky@insnergy.com";
		DisconnectManagementService disconnectManagementService = new DisconnectManagementService();
		disconnectManagementService.createDisconnectedRule(deviceId, email);
	}
}