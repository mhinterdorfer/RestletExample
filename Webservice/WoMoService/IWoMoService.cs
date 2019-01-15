using System;
using System.Collections.Generic;
using System.Linq;
using System.Runtime.Serialization;
using System.ServiceModel;
using System.Text;

namespace WoMoService
{
    // NOTE: You can use the "Rename" command on the "Refactor" menu to change the interface name "IWoMoService" in both code and config file together.
    [ServiceContract]
    public interface IWoMoService
    {
        [OperationContract]
        void DoWork();
    }
}
