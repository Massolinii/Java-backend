package com.epicode.workSpaceReservationApplication.service;

import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.epicode.workSpaceReservationApplication.enums.SpaceTypology;
import com.epicode.workSpaceReservationApplication.model.Building;
import com.epicode.workSpaceReservationApplication.model.Reservation;
import com.epicode.workSpaceReservationApplication.model.Space;
import com.epicode.workSpaceReservationApplication.repository.SpaceRepository;

@Service
public class SpaceService {
	
	@Autowired
    SpaceRepository spaceRepository;

    @Autowired
    @Qualifier("WorkspaceNoParamsBean")
    ObjectProvider<Space> spaceNoParamsProvider;

    @Autowired
    @Qualifier("WorkspaceWithParamsBean")
    ObjectProvider<Space> spaceWithParamsProvider;

    @Autowired
    @Qualifier("WorkspaceFakeBean")
    ObjectProvider<Space> spaceFakeProvider;

    public Space createSpaceNoParamsWorkspace() {
        return spaceNoParamsProvider.getObject();
    }

    public Space createSpaceWithParamsWorkspace(
            String name, String description,
            SpaceTypology type, int maxOccupancy) {
        return spaceWithParamsProvider.getObject();
    }

    public Space createWorkspaceFake() {
        return spaceFakeProvider.getObject();
    }

    public boolean checkSpaceIsAvailable(
            Space workspace, Reservation newReservation) {
        for (Reservation reservation : workspace.getReservations()) {
            if (reservation.getData().isEqual(newReservation.getData())) {
                if (checkScheduleOverlap(
                        newReservation.getStartTime(),
                        newReservation.getEndTime(),
                        reservation.getStartTime(),
                        reservation.getEndTime()))
                    return false;
            }
        }
        return true;
    }

    public void save(Space space) {
        spaceRepository.save(space);
    }

    public void update(Space space) {
        spaceRepository.save(space);
    }

    public void delete(Space space) {
        spaceRepository.delete(space);
    }
    
    private boolean checkScheduleOverlap(
            LocalTime startTime1, LocalTime endTime1,
            LocalTime startTime2, LocalTime endTime2) {
        return !endTime1.isBefore(startTime2) && !endTime2.isBefore(startTime1);
    }

    public Space getById(Long id) {
        return spaceRepository.findById(id).get();
    }

    public List<Space> getByName(String name) {
        return spaceRepository.findByName(name);
    }

    public List<Space> getAll() {
        return spaceRepository.findAll();
    }

    public List<Space> findByTypeAndCity(SpaceTypology type, String city) {
        return spaceRepository.findByTypeAndCity(type, city);
    }
    
    public Space getByNameAndBuilding(String name, Building building) {
        return spaceRepository.findByNameAndBuilding(name, building);
    }



}
