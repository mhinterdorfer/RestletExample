using System;
using System.Collections.Generic;
using System.Data.Services;
using System.Data.Services.Providers;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WoMoService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the class name "WoMoService" in code, svc and config file together.
    // NOTE: In order to launch WCF Test Client for testing this service, please select WoMoService.svc or WoMoService.svc.cs at the Solution Explorer and start debugging.
    public class WoMoService : EntityFrameworkDataService<WoMoEntities>
    {
        public static void InitializeService(DataServiceConfiguration config)
        {
            config.SetEntitySetAccessRule("*", EntitySetRights.All);
            config.DataServiceBehavior.MaxProtocolVersion = System.Data.Services.Common.DataServiceProtocolVersion.V3;
        }
    }
}
