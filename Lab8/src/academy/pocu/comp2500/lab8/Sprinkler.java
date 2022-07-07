package academy.pocu.comp2500.lab8;

import java.util.ArrayList;
public class Sprinkler extends SmartDevice implements ISprayable{
    private static final int SPRAY_AMOUNT = 15;
    private ArrayList<Schedule> schedules = new ArrayList<>();
    private int schedules_index;
    private int tickCount;
    private Schedule scheduleOrNull;
    private boolean isOffNextTick;
    private boolean isValidSchedule;

    public void addSchedule(Schedule schedule) {
        schedules.add(schedule);
    }

    @Override
    public void onTick() {
        tick++;
        if (isOffNextTick == true) {
            if (isOn == true) {
                onAt = tick;
                isOn = false;
            }
            isOffNextTick = false;
            return;
        }

        if (scheduleOrNull == null) {
            for (int i = schedules_index; i < schedules.size(); i++) {
                Schedule s = schedules.get(i);
                if (tick <= s.getTickAt() + s.getTickTill() && s.getTickAt() != 0) {
                    scheduleOrNull = s;
                    schedules_index = i;
                    if (tick <= s.getTickAt()) {
                        isValidSchedule = true;
                    } else {
                        tickCount = tick - scheduleOrNull.getTickAt();
                        isValidSchedule = false;
                    }
                    break;
                }
            }

            if (schedules_index >= schedules.size() || scheduleOrNull == null) {
                if (isOn == true) {
                    onAt = tick;
                    isOn = false;
                }
                return;
            }
        }

        if (tick >= scheduleOrNull.getTickAt()  && isValidSchedule == true && tickCount <= scheduleOrNull.getTickTill()) {
            tickCount++;
            if (isOn == false) {
                onAt = tick;
                isOn = true;
            }
        } else {
            if (isValidSchedule == false) {
                tickCount++;
            }
            if (isOn == true) {
                onAt = tick;
                isOn = false;
            }
        }

        if (tickCount == scheduleOrNull.getTickTill()) {
            scheduleOrNull = null;
            tickCount = 0;
            schedules_index++;
            isOffNextTick = true;
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
