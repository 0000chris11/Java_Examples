/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ZTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import java.util.UUID;

/**
 *
 * @author C0FII
 */

class AlertService {

      private final MapAlertDAO storage;

      public UUID raiseAlert() {
            return this.storage.addAlert(new Date());
      }

      public Date getAlertTime(UUID id) {
            return this.storage.getAlert(id);
      }

      public AlertService(MapAlertDAO MAD) {
            storage = MAD;
      }
}

interface AlterDAO {

      Map<UUID, Date> alerts = new HashMap<UUID, Date>();

      UUID addAlert(Date time);

      Date getAlert(UUID id);
}

class MapAlertDAO implements AlterDAO {

      //private final Map<UUID, Date> alerts = new HashMap<UUID, Date>();
      @Override
      public UUID addAlert(Date time) {
            UUID id = UUID.randomUUID();
            this.alerts.put(id, time);
            return id;
      }

      @Override
      public Date getAlert(UUID id) {
            return this.alerts.get(id);
      }

}
