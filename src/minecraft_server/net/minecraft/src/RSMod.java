package net.minecraft.src;

public class RSMod extends AddonExt {
	private static RSMod instance;
	
	private RSMod() {
		super("Ruins and Structures", "1.0.0", "RS");
	}

	@Override
	public void Initialize() {
		FCAddOnHandler.LogMessage(this.getName() + " Version " + this.getVersionString() + " Initializing...");
		initDecoIntegration();
		
		if (!RSDecoIntegration.isDecoInstalled()) {
			throw new RuntimeException("Deco must be installed to use Ruins and Structures!");
		}
		
		FCAddOnHandler.LogMessage(this.getName() + " Initialized");
	}
	
	public void initDecoIntegration() {
		RSDecoIntegration.init();
	}
	
	public static RSMod getInstance() {
		if (instance == null) {
			instance = new RSMod();
		}
		
		return instance;
	}
}