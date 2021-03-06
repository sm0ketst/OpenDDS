// -*- C++ -*-

//=============================================================================
/**
 *  @file    DataReader_Listener_Base.inl
 *
 *
 *  @author  Friedhelm Wolf (fwolf@dre.vanderbilt.edu)
 */
//=============================================================================

#ifndef DDS_WRAPPER_DATAREADER_LISTENER_BASE_INL_
#define DDS_WRAPPER_DATAREADER_LISTENER_BASE_INL_

ACE_INLINE void
DataReader_Listener_Base::on_data_available(DDS::DataReader_ptr)
  throw (CORBA::SystemException)
{
  // no op
}

ACE_INLINE void
DataReader_Listener_Base::on_requested_deadline_missed (
    DDS::DataReader_ptr,
    const DDS::RequestedDeadlineMissedStatus &)
  throw (CORBA::SystemException)
{
  // no op
}

ACE_INLINE void
DataReader_Listener_Base::on_requested_incompatible_qos (
    DDS::DataReader_ptr,
    const DDS::RequestedIncompatibleQosStatus &)
  throw (CORBA::SystemException)
{
  // no op
}

ACE_INLINE void
DataReader_Listener_Base::on_liveliness_changed (
    DDS::DataReader_ptr,
    const DDS::LivelinessChangedStatus &)
  throw (CORBA::SystemException)
{
  // no op
}

ACE_INLINE void
DataReader_Listener_Base::on_subscription_matched (
    DDS::DataReader_ptr,
    const DDS::SubscriptionMatchedStatus &)
  throw (CORBA::SystemException)
{
  // no op
}

ACE_INLINE void
DataReader_Listener_Base::on_sample_rejected (
    DDS::DataReader_ptr,
    const DDS::SampleRejectedStatus&)
  throw (CORBA::SystemException)
{
  // no op
}

ACE_INLINE void
DataReader_Listener_Base::on_sample_lost (
    DDS::DataReader_ptr,
    const DDS::SampleLostStatus&)
  throw (CORBA::SystemException)
{
  // no op
}


#endif /* DDS_WRAPPER_DATAREADER_LISTENER_BASE_INL_ */
