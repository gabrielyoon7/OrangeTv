package manage;

public interface Factory <T extends Manageable>{
	T create();
}
