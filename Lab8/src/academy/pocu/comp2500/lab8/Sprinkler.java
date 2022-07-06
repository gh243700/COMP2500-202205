package academy.pocu.comp2500.lab8;

import java.util.ArrayList;
public class Sprinkler extends SmartDevice implements ISprayable{
    private static final int SPRAY_AMOUNT = 15;
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private int schedules_index;
    private int tickCount;
    private Schedule scheduleOrNull;

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    @Override
    public void onTick() {
        if (scheduleOrNull == null) {
            for (int i = schedules_index; i < schedules.size(); i++) {
                Schedule s = schedules.get(i);
                if (tick < s.getTickAt() && s.getTickAt() != 0) {
                    scheduleOrNull = s;
                    onAt = tick;
                    schedules_index = i;
                    break;
                }
            }

            if (schedules_index >= schedules.size() || scheduleOrNull == null) {
                tick++;
                if (isOn == true) {
                    onAt = tick;
                    isOn = false;
                }
                return;
            }

        }
        tick++;
        if (tick >= scheduleOrNull.getTickAt() && tickCount <= scheduleOrNull.getTickTill()) {
            if (isOn == false) {
                onAt = tick;
                isOn = true;
            }
            tickCount++;
            if (tickCount == scheduleOrNull.getTickTill()) {
                scheduleOrNull = null;
                tickCount = 0;
                schedules_index++;
            }
        } else {
            if (isOn == true) {
                onAt = tick;
                isOn = false;
            }
        }
    }

    @Override
    public void install(Planter planter) {
        planter.installSprinkler(this);
    }

    @Override
    public void spray(Planter planter) {
        if (isOn == true) {
            planter.addWaterAmount(SPRAY_AMOUNT);
        }
    }
}
